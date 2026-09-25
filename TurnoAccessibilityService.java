package com.peyaturnos;
import android.accessibilityservice.AccessibilityService; import android.view.accessibility.AccessibilityEvent; import android.view.accessibility.AccessibilityNodeInfo; import android.media.AudioManager; import android.media.ToneGenerator; import android.os.VibrationEffect; import android.os.Vibrator; import android.content.Context;
public class TurnoAccessibilityService extends AccessibilityService {
 private long last=0;
 public void onAccessibilityEvent(AccessibilityEvent e){ if(System.currentTimeMillis()-last<2500)return; String s=tree(e.getSource()); if(s==null)return;
   String x=s.toLowerCase(); if((x.contains("turno")||x.contains("horario")||x.contains("disponible")) && (x.contains("acept")||x.contains("reserv")||x.contains("dispon"))){ alert(); last=System.currentTimeMillis(); }
 }
 private String tree(AccessibilityNodeInfo n){ if(n==null)return ""; StringBuilder b=new StringBuilder(); walk(n,b); return b.toString(); }
 private void walk(AccessibilityNodeInfo n,StringBuilder b){ if(n==null)return; CharSequence t=n.getText(); if(t!=null)b.append(t).append(" "); for(int i=0;i<n.getChildCount();i++)walk(n.getChild(i),b); }
 private void alert(){ try{new ToneGenerator(AudioManager.STREAM_NOTIFICATION,100).startTone(ToneGenerator.TONE_PROP_BEEP,700); Vibrator v=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE); if(v!=null)v.vibrate(VibrationEffect.createWaveform(new long[]{0,250,150,250},-1));}catch(Exception ignored){} }
 public void onInterrupt(){}
}
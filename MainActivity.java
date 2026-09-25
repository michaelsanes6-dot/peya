package com.peyaturnos;
import android.app.*; import android.os.*; import android.content.*; import android.graphics.Color; import android.provider.Settings; import android.view.*; import android.widget.*;
public class MainActivity extends Activity {
  EditText min, max, zone;
  public void onCreate(Bundle b){super.onCreate(b); LinearLayout l=new LinearLayout(this); l.setOrientation(LinearLayout.VERTICAL);
    TextView t=new TextView(this); t.setText("PeyaTurnos\n\nDetector de turnos"); t.setTextSize(24); t.setTextColor(Color.BLACK);
    l.addView(t); zone=new EditText(this); zone.setHint("Zona (opcional)"); l.addView(zone);
    min=new EditText(this); min.setHint("Hora mínima, ej. 08:00"); l.addView(min);
    max=new EditText(this); max.setHint("Hora máxima, ej. 23:00"); l.addView(max);
    Button b1=new Button(this); b1.setText("Activar detector"); l.addView(b1);
    TextView info=new TextView(this); info.setText("\nPara detectar la pantalla de PeYa Rider debes activar el servicio de accesibilidad de PeyaTurnos."); l.addView(info);
    b1.setOnClickListener(v->startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)));
    setContentView(l);
  }
}
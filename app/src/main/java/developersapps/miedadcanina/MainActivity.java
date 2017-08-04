package developersapps.miedadcanina;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final  String TAG="MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int edadperro;
        Button clic= (Button) findViewById(R.id.boton);
        final EditText anios = (EditText) findViewById(R.id.edad);
        final TextView respuesta = (TextView) findViewById(R.id.respuesta);

        Log.d("hola soy un tag" ,"la app fue creada");

        ImageView dogimage=(ImageView) findViewById(R.id.imagenperro);
        dogimage.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dog));
        respuesta.setText("");
        clic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resp = getString(R.string.respuesta);
                String mensaje = getString(R.string.mensaje);
                String ageString = anios.getText().toString();
                    try {
                    int age = Integer.parseInt(ageString);
                    respuesta.setText(resp + (age * 6));
                    Log.i(TAG,"Se inserto el numero entero");
                } catch (NumberFormatException e) {
                    //respuesta.setText("Inserta un numero entero no seas pendejo :v");
                    Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_LONG).show();
                    Log.e(TAG,"no se inserto un numero entero");
                }
            }
        });
    }
}

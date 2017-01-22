package sergituxdiblasio.com.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Sergio Di Blasio", "55555555", "sergiodiblasio@hotmail.com"));
        contactos.add(new Contacto("Pedro Sanchez", "88888888", "pepe_san@hotmail.com"));
        contactos.add(new Contacto("Raul Acosta", "77777777", "rauloac@hotmail.com"));
        contactos.add(new Contacto("Jacinta Arauz", "99999999", "arauzjacinta@hotmail.com"));
        contactos.add(new Contacto("Lionel Messi", "66666666", "liomessi@hotmail.com"));

        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //INTENT EXPLLICITO
                //POSICION DESDE CERO HASTA N-1
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                //intent... desde donde estoy... hacia donde quiero ir
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });

    }
}

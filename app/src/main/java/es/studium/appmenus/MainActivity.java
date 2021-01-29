package es.studium.appmenus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener{
TextView texto;
PopupMenu popupMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto= findViewById(R.id.texto);
        registerForContextMenu(texto);//registro el menu contextual en texto, con ello aparece cuando le damos a texto.
        texto.setOnClickListener(this);
        popupMenu=new PopupMenu(this, texto);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(this);
    }
    public void onClick(View view){
        popupMenu.show();
    }
    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()) {

            case R.id.mFile:
                Toast.makeText(this, R.string.sFile, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSettings:
                Toast.makeText(this, R.string.sSetting, Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
    //Menu contextual
    //Creacion del menu Contextual
    public void onCreateContextMenu(ContextMenu contextMenu, View view,ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(contextMenu, view, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, contextMenu);
    }
    //Que hace el menu contextual
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {

            case R.id.mAbout:
                Toast.makeText(this, R.string.sAbout, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSettings:
                Toast.makeText(this, R.string.sSetting, Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    //FIN Menu contextual
    //Creacion de Menu
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
    // Que hace el menu
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.mFile:
                Toast.makeText(this, R.string.sFile, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mAbout:
                Toast.makeText(this, R.string.sAbout, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSettings:
                Toast.makeText(this, R.string.sSetting, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mOpen:
                Toast.makeText(this, R.string.sOpen, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSave:
                Toast.makeText(this, R.string.sSave, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //FIN Menu
}
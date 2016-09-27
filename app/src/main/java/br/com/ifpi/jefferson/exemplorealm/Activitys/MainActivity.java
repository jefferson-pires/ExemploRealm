package br.com.ifpi.jefferson.exemplorealm.Activitys;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import br.com.ifpi.jefferson.exemplorealm.R;
import br.com.ifpi.jefferson.exemplorealm.pojos.Compra;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm ;
    private EditText txtDescricao;
    private EditText txtData;
    private RealmResults<Compra> compras;
    public static String data = "";
    private static Button bt_Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDescricao = (EditText) findViewById(R.id.descricao);
        bt_Data = (Button) findViewById(R.id.bt_DatePicker);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext()).build();
        realm = Realm.getInstance(realmConfig);
        compras = realm.where(Compra.class).findAll();

    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstance){
            //Usa a data atual como a data default
            final Calendar c = Calendar.getInstance();
            int ano = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int dia = c.get(Calendar.DAY_OF_MONTH);

            //Cria uma nova instancia do DatePickerDialog e a retorna
            return new DatePickerDialog(getActivity(), this, ano, mes, dia);
        }

        public void onDateSet(DatePicker view, int ano, int mes, int dia ){
            //Faz alguma coisa com a data escolhida pelo usuario
            data = (dia + "/" + (mes+1) + "/" + ano);
            bt_Data.setText(data);

        }
    }

    private void toast(String msg){

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showDatePickerDialog(View view){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void salvarCompra(View view){
        String descrição = txtDescricao.getText().toString();

        realm.beginTransaction();
        Compra compra = realm.createObject(Compra.class);
        compra.setData(data);
        compra.setDescrição(descrição);
        compra.setId(compras.size()+1);
        realm.commitTransaction();
        realm.close();

        toast("Compra criada com sucesso");
    }

    public void compras(View view){

        Intent intent = new Intent(this,ComprasActivity.class);
        startActivity(intent);
    }
}

package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tb_usuario extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_nombre,ed_apellido,ed_correo,ed_usuario,ed_clave,ed_tipo,ed_estado,ed_pregunta,ed_respuesta,ed_id;
    private Button btn_usuario;
    boolean inputE0=false;
    boolean inputE1=false;
    boolean inputE2=false;
    boolean inputE3=false;
    boolean inputE4=false;
    boolean inputE5=false;
    boolean inputE6=false;
    boolean inputE7=false;
    boolean inputE8=false;
    boolean inputE9=false;
    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_usuario);

        ed_nombre= findViewById(R.id.ed_nombre);
        ed_apellido= findViewById(R.id.ed_apellido);
        ed_correo= findViewById(R.id.ed_correo);
        ed_usuario= findViewById(R.id.ed_usuario);
        ed_clave= findViewById(R.id.ed_clave);

        ed_tipo= findViewById(R.id.ed_tipo);
        ed_estado= findViewById(R.id.ed_estado);
        ed_pregunta= findViewById(R.id.ed_pregunta);
        ed_respuesta= findViewById(R.id.ed_respuesta);
ed_id = findViewById(R.id.ed_id);


        String senal = "";
        String id_usuario = "";
        String nombre = "";
        String apellido = "";
        String correo = "";
        String usuario = "";
        String clave = "";

        String tipo = "";
        String estado = "";
        String pregunta = "";
        String respuesta = "";

        try {
            Intent intent= getIntent();
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
                id_usuario = bundle.getString("id_usuario");
                senal = bundle.getString("senal");
                nombre = bundle.getString("nombre");
                apellido = bundle.getString("apellido");
                correo = bundle.getString("correo");
                usuario = bundle.getString("usuario");
               clave = bundle.getString("clave");
                tipo = bundle.getString("tipo");
                estado = bundle.getString("estado");
                pregunta = bundle.getString("pregunta");
               respuesta = bundle.getString("respuesta");


                if(senal.equals("1")){
                   ed_id.setText(id_usuario);
                  ed_nombre.setText(nombre);
                    ed_apellido.setText(apellido);
                    ed_correo.setText(correo);
                    ed_usuario.setText(usuario);
                    ed_clave.setText(clave);
                    ed_tipo.setText(tipo);
                    ed_estado.setText(estado);
                    ed_apellido.setText(pregunta);
                    ed_respuesta.setText(respuesta);
                }
            }
        }catch (Exception e){

        }


    }

    public void alta(View v){
        if(ed_id.getText().toString().length()==0){
            ed_id.setError("Campo obligatorio");
            inputE0=false;

        }else{
            inputE0=true;
        }
        if(ed_nombre.getText().toString().length()==0){
            ed_nombre.setError("Campo obligatorio");
            inputE1=false;

        }else{
            inputE1=true;
        }
        if(ed_apellido.getText().toString().length()==0){
           ed_apellido.setError("Campo obligatorio");
            inputE2=false;

        }else{
            inputE2=true;
        }
        if(ed_correo.getText().toString().length()==0){
            ed_correo.setError("Campo obligatorio");
            inputE3=false;

        }else{
            inputE3=true;
        }
        if(ed_usuario.getText().toString().length()==0){
            ed_usuario.setError("Campo obligatorio");
            inputE4=false;

        }else{
            inputE4=true;
        }
        if(ed_clave.getText().toString().length()==0){
            ed_clave.setError("Campo obligatorio");
            inputE5=false;

        }else{
            inputE5=true;
        }
        if(ed_tipo.getText().toString().length()==0){
            ed_tipo.setError("Campo obligatorio");
            inputE6=false;

        }else{
            inputE6=true;
        }
        if(ed_estado.getText().toString().length()==0){
            ed_estado.setError("Campo obligatorio");
            inputE7=false;

        }else{
            inputE7=true;
        }
        if(ed_pregunta.getText().toString().length()==0){
            ed_pregunta.setError("Campo obligatorio");
            inputE8=false;

        }else{
            inputE8=true;
        }
        if(ed_respuesta.getText().toString().length()==0){
          ed_respuesta.setError("Campo obligatorio");
            inputE9=false;

        }else{
            inputE9=true;
        }
        if(inputE0 && inputE1 && inputE2 && inputE3 && inputE4 && inputE5 && inputE6 && inputE7 && inputE8 && inputE9) {
            try {

                datos.setId_usuario(Integer.parseInt(ed_id.getText().toString()));
                datos.setNombre(ed_nombre.getText().toString());
                datos.setApellido(ed_apellido.getText().toString());
                datos.setCorreo(ed_correo.getText().toString());
                datos.setUsuario(ed_usuario.getText().toString());
                datos.setClave(ed_clave.getText().toString());
                datos.setTipo(Integer.parseInt(ed_tipo.getText().toString()));
                datos.setEstado(Integer.parseInt(ed_estado.getText().toString()));
                datos.setPregunta(ed_pregunta.getText().toString());
                datos.setRespuesta(ed_respuesta.getText().toString());

              //  datos.setDescripcion(et_descripcion.getText().toString());
             //   datos.setPrecio(Double.parseDouble(et_precio.getText().toString()));

                if (conexion.InsertTradicional(datos)) {
                    Toast.makeText(this, "Registro con exito!!", Toast.LENGTH_SHORT).show();
                    limpiarDatos();
                } else {
                    Toast.makeText(this, "Error. Ya existe un registro\n" +
                            "id: " + ed_id.getText().toString(), Toast.LENGTH_SHORT).show();
                    limpiarDatos();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Error, Ya existe", Toast.LENGTH_SHORT).show();

            }
        }
    }


    public void limpiarDatos(){
        ed_nombre.setText(null);
        ed_apellido.setText(null);
        ed_correo.setText(null);
        ed_usuario.setText(null);
        ed_clave.setText(null);
        ed_tipo.setText(null);
        ed_estado.setText(null);
        ed_pregunta.setText(null);
        ed_respuesta.setText(null);
    }


    @Override
    public void onClick(View view) {

    }
}
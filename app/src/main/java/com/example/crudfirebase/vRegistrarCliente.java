package com.example.crudfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class vRegistrarCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vregistrar_cliente);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText dnicliente = findViewById(R.id.txtDniCliente);
        EditText apellidocliente = findViewById(R.id.txtApellidoCliente);
        EditText nombrecliente = findViewById(R.id.txtNombreCliente);
        EditText telefonocliente = findViewById(R.id.txtTelefonoCliente);
        EditText correocliente = findViewById(R.id.txtCOrreoCliente);
        EditText direccioncliente = findViewById(R.id.txtDireccionCliente);

        Button btnregistrarcliente = findViewById(R.id.btnRegistrarCliente);


        String idLogeado = FirebaseAuth.getInstance().getCurrentUser().getUid();

        btnregistrarcliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = dnicliente.getText().toString();
                String apellido = apellidocliente.getText().toString();
                String nombre = nombrecliente.getText().toString();
                String telefono = telefonocliente.getText().toString();
                String correo = correocliente.getText().toString();
                String direccion = direccioncliente.getText().toString();

                if (TextUtils.isEmpty(dni)||TextUtils.isEmpty(apellido)||TextUtils.isEmpty(nombre)||TextUtils.isEmpty(telefono)||TextUtils.isEmpty(correo)||TextUtils.isEmpty(direccion)){
                    Toast.makeText(vRegistrarCliente.this,"Todos los campos son obligatorios",Toast.LENGTH_SHORT).show();
                }else{
                    DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
                    String idCliente = dr.child("clientes").push().getKey();

                    Map<String, String > client = new HashMap<>();
                    client.put("dni",dni);
                    client.put("apellido",apellido);
                    client.put("nombre", nombre);
                    client.put("telefono",telefono);
                    client.put("correo",correo);
                    client.put("direccion",direccion);

                    dr.child("clientes").child(idLogeado).child(idCliente).setValue(client).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(vRegistrarCliente.this,"Cliente Registrado",Toast.LENGTH_SHORT).show();
                                Intent con2 = new Intent(vRegistrarCliente.this,vClientes.class);
                                startActivity(con2);

                            }else{
                                Toast.makeText(vRegistrarCliente.this,"Error de Registro",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });





                }


            }
        });





    }
}
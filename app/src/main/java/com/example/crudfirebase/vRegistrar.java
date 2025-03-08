package com.example.crudfirebase;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;

public class vRegistrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vregistrar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnregistrarusuario = findViewById(R.id.btnRegistrarUsuario);
        EditText txtdniusuario = findViewById(R.id.txtDniUsuario);
        EditText txtapellidousuario = findViewById(R.id.txtApellidoUsuario);
        EditText txtnombreusuario = findViewById(R.id.txtNombreUsuario);
        EditText txttelefonousuario = findViewById(R.id.txtTelefonoUsuario);
        EditText txtemailusuario = findViewById(R.id.txtCorreoUsuario);
        EditText txtpassusuario = findViewById(R.id.txtPassUsuario);

        btnregistrarusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dniusuario = txtdniusuario.getText().toString();
                String apellidousuario = txtapellidousuario.getText().toString();
                String nombreusuario = txtnombreusuario.getText().toString();
                String telefonousuario = txttelefonousuario.getText().toString();
                String emailusuario = txtemailusuario.getText().toString();
                String passusuario = txtpassusuario.getText().toString();


                if(TextUtils.isEmpty(dniusuario)||TextUtils.isEmpty(apellidousuario)||TextUtils.isEmpty(nombreusuario)||TextUtils.isEmpty(telefonousuario)||TextUtils.isEmpty(emailusuario)||TextUtils.isEmpty(passusuario)){
                    Toast.makeText(vRegistrar.this,"Todos los campos son obligatorios",Toast.LENGTH_SHORT).show();
                }
                else{
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailusuario,passusuario).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                String UserID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                Map<String, String> user = new HashMap<>();

                                user.put("dni", dniusuario);
                                user.put("apellido", apellidousuario);
                                user.put("nombre", nombreusuario);
                                user.put("telefono", telefonousuario);
                                user.put("email", emailusuario);

                                FirebaseDatabase.getInstance().getReference().child("usuarios").child(UserID).setValue(user);
                                Toast.makeText(vRegistrar.this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(vRegistrar.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
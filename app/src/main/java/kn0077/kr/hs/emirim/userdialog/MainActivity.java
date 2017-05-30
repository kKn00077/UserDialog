package kn0077.kr.hs.emirim.userdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textName,textEmail;
    EditText editName,editEmail;
    View dlgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but=(Button)findViewById(R.id.but);
        but.setOnClickListener(this);
        textName=(TextView)findViewById(R.id.text_name);
        textEmail=(TextView)findViewById(R.id.text_email);
    }

    @Override
    public void onClick(View v) {
        dlgV=View.inflate(this,R.layout.dialog,null); // null은 dialog.xml이 실행되기 전에 부모 화면이 있다면 먼저 실행시키도록 하는 인자
        AlertDialog.Builder dialog=new AlertDialog.Builder(this); // getApplicationContext()도 동일
        dialog.setTitle("Input User Information");
        dialog.setIcon(R.mipmap.star);
        dialog.setView(dlgV);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editName=(EditText)dlgV.findViewById(R.id.edit_name);
                editEmail=(EditText)dlgV.findViewById(R.id.edit_email);
                textName.setText(editName.getText());
                textEmail.setText(editEmail.getText());
            }
        });
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast= new Toast(MainActivity.this);//그냥 this는 핸들러의 객체를 의미하기 때문
                View toastV=View.inflate(MainActivity.this,R.layout.toast,null);
                TextView textToast=(TextView)toastV.findViewById(R.id.text_toast);
                textToast.setText("취소되었군요!!!!");
                toast.setView(toastV);
                toast.show();
            }
        });
        dialog.show();

    }
}

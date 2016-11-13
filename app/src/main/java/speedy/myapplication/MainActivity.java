package speedy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnAddStudent = (Button) findViewById(R.id.btnEkle);
        Button btnShowStudentList = (Button) findViewById(R.id.btnListele);
        final EditText etStudentName = (EditText) findViewById(R.id.etStudentName);
        final EditText etStudentNumber = (EditText) findViewById(R.id.etStudentNumber);
        final EditText etStudentDepartment = (EditText) findViewById(R.id.etStudentDepartment);

        studentList = new ArrayList<>();

        Student student1 = new Student("Şebnem Saliha Çakıroğlu", "Bilgisayar Mühendisliği",10052096);
        Student student2 = new Student("Elif Kurt", "Matematik Mühendisliği",10052094);
        Student student3 = new Student("Muhammet Çakır", "Elektronik Mühendisliği",14529879);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etStudentName.getText().toString();
                int number = Integer.parseInt(etStudentNumber.getText().toString());
                String department = etStudentDepartment.getText().toString();

//               if(name==null || number==0 || department==null)
//                   Toast.makeText(this,"Alanlar Boş bırakılamaz...",Toast.LENGTH_LONG).show();

                studentList.add(new Student(name, department,number));

            }
        });


        btnShowStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> names = new ArrayList<String>();
                ArrayList<Integer> ids = new ArrayList<Integer>();
                ArrayList<String> departments = new ArrayList<String>();

                for(Student student:studentList){
                    names.add(student.getStudentName());
                    ids.add(student.getStudentNumber());
                    departments.add(student.getStudentDepartment());
                }

                Intent intent = new Intent(MainActivity.this, StudentListele.class);
                intent.putExtra("StudentNames",names);
                intent.putExtra("StudentDepartments",departments);
                intent.putExtra("StudentNumbers",ids);

                startActivity(intent);
            }
        });

    }
}

package speedy.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hafta_Sonu on 12.11.2016.
 */

public class StudentListele extends AppCompatActivity{

    ArrayList<Student> studentsList ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentlistele);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> names = extras.getStringArrayList("StudentNames");
        ArrayList<Integer> ids = extras.getIntegerArrayList("StudentNumbers");
        ArrayList<String> departments = extras.getStringArrayList("StudentDepartments");

        studentsList= new ArrayList<Student>();

               for (int i=0; i<names.size();i++){
            studentsList.add(new Student(names.get(i),departments.get(i),ids.get(i)));
        }

        ListView listView = (ListView) findViewById(R.id.listView);

        final myAdapter myAdapter = new myAdapter(this,studentsList);
        listView.setAdapter(myAdapter);
    }

    public class myAdapter extends BaseAdapter {
        Context context;
        List<Student> objects;

        public myAdapter(Context context,  List<Student> objects) {
            this.context = context;
            this.objects = objects;
        }

        @Override
        public int getCount() {
            return objects.size();
        }

        @Override
        public Student getItem(int position) {
            return objects.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Student p = getItem(position);
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.list_item, null);

            TextView name= (TextView) view.findViewById(R.id.tvStudentName);
            TextView department = (TextView) view.findViewById(R.id.tvStudentDepartment);
            TextView number = (TextView) view.findViewById(R.id.tvStudentNumber);

            name.setText(p.getStudentName());
            department.setText(p.getStudentDepartment());
            number.setText(p.getStudentNumber()+"");


            return view;

        }
    }
}

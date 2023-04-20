package eu.tutorials.dialoglistview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import eu.tutorials.dialoglistview.adapter.PhanMemAdapter;
import eu.tutorials.dialoglistview.model.PhanMem;

public class MainActivity extends AppCompatActivity {
    EditText edt_1, edt_2;
    RadioButton rd_1, rd_2, rd_3;
    Button btn_update, btn_view, btn_add;
    ListView lv_banh;

    PhanMemAdapter phanMemAdapter;
    ArrayList<PhanMem> phanMemArrayList = new ArrayList<>();
    int hinhAnh;

    int viTri = -1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        xuLySuKien();
    }

    private void xuLySuKien() {
        phanMemArrayList.add(new PhanMem("Android 1.5", "Cupcake", R.drawable.ic_launcher_foreground));
        phanMemArrayList.add(new PhanMem("Android 1.6", "Donut", R.drawable.ic_launcher_background));
        phanMemAdapter = new PhanMemAdapter(this, R.layout.item_cake, phanMemArrayList);
        lv_banh.setAdapter(phanMemAdapter);
        themPhanMem();
        xoaPhanMem();
        suaPhanMem();
    }

    private void suaPhanMem() {

        lv_banh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                edt_1.setText(phanMemArrayList.get(position).getTenPhienBan() + "");
                edt_2.setText(phanMemArrayList.get(position).getTenBanh() + "");
                viTri = position;
                return false;
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phanMemArrayList.set(viTri, new PhanMem(edt_1.getText().toString(), edt_2.getText().toString(), hinhAnh));
            }
        });
    }

    private void xoaPhanMem() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("bạn có đồng ý xóa?");


        lv_banh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        phanMemArrayList.remove(position);
                        phanMemAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });

    }

    private void themPhanMem() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rd_1.isChecked()) {
                    hinhAnh = R.drawable.ic_launcher_background;
                }
                if (rd_2.isChecked()) {
                    hinhAnh = R.drawable.ic_launcher_background;
                }
                if (rd_3.isChecked()) {
                    hinhAnh = R.drawable.ic_launcher_background;
                }
                phanMemArrayList.add(new PhanMem(edt_1.getText().toString(), edt_2.getText().toString(), hinhAnh));
                phanMemAdapter.notifyDataSetChanged();
            }
        });
    }


    private void anhXa() {
        edt_1 = findViewById(R.id.edt_1);
        edt_2 = findViewById(R.id.edt_2);
        rd_1 = findViewById(R.id.rd_1);
        rd_2 = findViewById(R.id.rd_2);
        rd_3 = findViewById(R.id.rd_3);
        btn_update = findViewById(R.id.btn_update);
        btn_add = findViewById(R.id.btn_add);
        btn_view = findViewById(R.id.btn_view);
        lv_banh = findViewById(R.id.lv_banh);
    }
}
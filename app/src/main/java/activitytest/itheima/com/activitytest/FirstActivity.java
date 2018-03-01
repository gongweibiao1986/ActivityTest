package activitytest.itheima.com.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        button = (Button)findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this,"aaaa",Toast.LENGTH_LONG).show();
                //销毁一个activity
//                finish();
//                Intent intent = new Intent("activitytest.itheima.com.activitytest.ACTION_START");
//                intent.addCategory("activitytest.itheima.com.activitytest.MY_CATEGORY");
                //浏览器
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
                //电话
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
                //数据传递
//                String data="Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
                //数据从目标活动回到上一个活动
                Log.d("FirstActivity",this.toString());
                Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
//                startActivityForResult(intent,1);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "you clicked add", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "you clicked remove", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }
}

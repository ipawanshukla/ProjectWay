package com.example.hp.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

        //import android.support.v7.app.AppCompatActivity;
        //import android.os.Bundle;
        import com.google.zxing.integration.android.IntentIntegrator;
        import com.google.zxing.integration.android.IntentResult;
        import android.content.Intent;
        import android.view.View;
        import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
        import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button scanBtn;
    private TextView formatTxt, contentTxt,scantxt;
    Animation fromtop;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        iv= findViewById(R.id.i);
        fromtop= AnimationUtils.loadAnimation(this,R.anim.fromtop);
        iv.setAnimation(fromtop);
        scantxt = (TextView)findViewById(R.id.scan_New);
        scanBtn.setOnClickListener(this);

    }
    public void onClick(View v){
        if(v.getId()==R.id.scan_button){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            String scann = scanningResult.getFormatName();
            formatTxt.setText("FORMAT: " + scanFormat);
            contentTxt.setText("CONTENT: " + scanContent);
            new contact().setScanres(scanContent);
            if(scanContent==null)
            {
                scantxt.setText("Result: " + "Scan Unsuccessful");
            }
            else {
                scantxt.setText("Scanned");
                /*ScanInfo sci = new ScanInfo(MainActivity.this);
                sci.execute(scanContent, new contact().getEU());*/
                /*getTest gt = new getTest(MainActivity.this);
                gt.execute(scanContent,new contact().getEU());*/
                TestActivity tq = new TestActivity(MainActivity.this);
                tq.execute(scanContent,new contact().getEU());
            }
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}

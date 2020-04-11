package com.example.dynamiclistactivity;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class DynListActivity extends Activity {
	private EditText et;
	private ListView lv;
	private ArrayList<String> al;
	private ArrayAdapter<String> aa;
	private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dyn_list);
        et=(EditText) findViewById(R.id.editText1);
        bt1=(Button) findViewById(R.id.button1);
        bt1.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(bt1.hasFocus())
					et.requestFocus();
			}
		});
        lv=(ListView) findViewById(R.id.listView1);
        al=new ArrayList<String>();
        aa=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,al);
        lv.setAdapter(aa);
        et.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keycode, KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction()==KeyEvent.ACTION_DOWN){
					if(keycode==KeyEvent.KEYCODE_ENTER){
						String litem=et.getText().toString();
						et.setText(" ");
						et.requestFocus();
						al.add(litem);
						aa.notifyDataSetChanged();
						return true;
			}
				}
				return false;
			}
		});
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(DynListActivity.this, "you've selected"+al.get(arg2),Toast.LENGTH_LONG).show();
				
			}
		});
    }
public void showlist(View v)
{
	String litem=et.getText().toString();
	al.add(litem);
	aa.notifyDataSetChanged();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dyn_list, menu);
        return true;
    }
    
}

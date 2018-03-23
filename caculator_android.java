package com.example.admin.testapp_21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class MainActivity extends AppCompatActivity {
    List<String> s=new ArrayList<String>();
    List<Character>c=new ArrayList<Character>();
    void click(final Button b, final EditText e)
    {
    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            e.append(b.getText().toString());
        }
    });


}
    List<Character>getYSF(String strs)
    {
        c.clear();
        int count=0;
        int len=strs.length()-1;
        strs.substring(0,len);
        char[] num=strs.toCharArray();
        char symbol[]={'+','-','*','/'};
        for( int i=0;i<len;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(num[i]==symbol[j])
                {
                    c.add(symbol[j]);
                    count++;

                }
            }}

        return  c;
    }
    List<String> getN(String strs)
    {
        s.clear();
        int count=0;
        int len=strs.length()-1;
        int begin=-1;
        strs.substring(0,len);
        char[] num=strs.toCharArray();
        char symbol[]={'+','-','*','/'};
        for( int i=0;i<len;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(num[i]==symbol[j])
                {

                    String a=strs.substring(begin+1,i);
                    s.add(a);
                    begin=i;
                }
            }
        }
        s.add(strs.substring(begin+1,strs.length()));
        return  s;

    }

    static int f2(List<Character> list,List<String> st)
    {

        int[] number=new int[st.size()];
        Stack<Integer> sk=new Stack<>();

        for(int i=0;i<st.size();i++)
        {
            number[i]=Integer.valueOf(st.get(i));
        }
        int  result=0;
        list.add(0,'+');
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)=='+')
                sk.push(number[i]);

            if(list.get(i)=='-')

                sk.push(-number[i]);
            if(list.get(i)=='*')
            {

                sk.push(number[i]*sk.pop());

            }
            if(list.get(i)=='/')
            {
                sk.push(sk.pop()/number[i]);

            }
        }
        for(int p=0;sk.size()>0;p++)
        {

            result=result+sk.pop();

        }
        return result;
    }

    int mkResult(final Button b,final EditText e)
    {

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t=e.getText().toString();
                t.substring(0,t.length()-1);
                int tx=f2(getYSF(t),getN(t));
                e.append("="+tx);

            }
        });
        return 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText data = (EditText) findViewById(R.id.data);
        final Button[] buttons=new Button[19];
        buttons[1] = (Button) findViewById(R.id.one);
        buttons[2] = (Button) findViewById(R.id.two);
        buttons[3]= (Button) findViewById(R.id.three);
        buttons[4] = (Button) findViewById(R.id.four);
        buttons[5] = (Button) findViewById(R.id.five);
        buttons[6] = (Button) findViewById(R.id.six);
        buttons[7] = (Button) findViewById(R.id.seven);
        buttons[8] = (Button) findViewById(R.id.eight);
        buttons[9] = (Button) findViewById(R.id.nine);
        buttons[0]= (Button) findViewById(R.id.zero);
        buttons[10] = (Button) findViewById(R.id.jia);
        buttons[11] = (Button) findViewById(R.id.jian);
        buttons[12] = (Button) findViewById(R.id.cheng);
        buttons[13]= (Button) findViewById(R.id.qyu);
        buttons[14]= (Button) findViewById(R.id.sin);
        buttons[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText("sin"+data.getText().toString()+"="+Math.sin(Integer.valueOf(data.getText().toString())));
            }
        });
        for(int i=0;i<14;i++)
        {

            click(buttons[i],data);
        }

        buttons[15]=(Button) findViewById(R.id.eql);

        mkResult(buttons[15],data);

        buttons[16]=(Button) findViewById(R.id.del);
        buttons[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key=data.getText().toString();
                data.setText(key.substring(0,key.length()-1));
            }
        });
        buttons[17]=(Button) findViewById(R.id.clr);
        buttons[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(null);
            }
        });





}}











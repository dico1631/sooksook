package com.lyj84.registeration;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice>  noticeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noticeListView=(ListView) findViewById(R.id.noticeListView);
        noticeList=new ArrayList<Notice>();
        noticeList.add(new Notice("db연동 전 테스트","이윤주","2018-04-29")); //직접 데이터 넣어봄
        noticeList.add(new Notice("db연동 전 테스트22","이윤주","2018-04-29"));
        adapter =new NoticeListAdapter(getApplicationContext(),noticeList); //차례대로 넣기
        noticeListView.setAdapter(adapter); //listview에 adapter 매칭

        final Button plantButton =(Button)findViewById(R.id.plantButton);
        final Button diaryButton =(Button)findViewById(R.id.diaryButton);
        final Button infoButton =(Button)findViewById(R.id.infoButton);
        final Button comButton =(Button)findViewById(R.id.comButton);
        final LinearLayout notice=(LinearLayout)findViewById(R.id.notice);


        plantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE); //더이상 공지사항이 보여지지 않도록
                plantButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                diaryButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                infoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                comButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new PlantFragment());
                fragmentTransaction.commit();
            }
        });

        diaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE); //더이상 공지사항이 보여지지 않도록
                diaryButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                plantButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                infoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                comButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new DiaryFragment());
                fragmentTransaction.commit();
            }
        });

        comButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE); //더이상 공지사항이 보여지지 않도록
                comButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                diaryButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                infoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                plantButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new communityFragment());
                fragmentTransaction.commit();
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE); //더이상 공지사항이 보여지지 않도록
                infoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                diaryButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                plantButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                comButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new InfoFragment());
                fragmentTransaction.commit();
            }
        });
    }

    private long lastTimeBackPressed;

    @Override
    public void onBackPressed(){  //뒤로가기 버튼 연달아 누르면 어플리케이션 종료
        if(System.currentTimeMillis()-lastTimeBackPressed<1500){
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.", Toast.LENGTH_SHORT);
        lastTimeBackPressed=System.currentTimeMillis();
    }
}

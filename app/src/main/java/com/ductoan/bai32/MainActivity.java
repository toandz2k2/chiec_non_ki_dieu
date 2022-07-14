package com.ductoan.bai32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ImageView hinh;
    Button play;
    TextView ketqua;
    String kq;
    int from = 0;
    int phanthuong[] = {2000,100,500,1,200,700,1000,400,2,900,3,300,800,4,1000,400,600,300,5,200,900,700,6,300};
    int vitri[] = {0,15,30,45,60,75,90,105,120,135,150,165,180,195,210,225,240,255,270,285,300,315,330,345};
    int vong[] = {360,720,1080,1440};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        hinh = (ImageView) findViewById(R.id.imhHinh);
        play = (Button) findViewById(R.id.btnPlay);
        ketqua = (TextView) findViewById(R.id.tvKetQua);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuly();
            }
        });
    }
    public void xuly(){
        int position = getRandom(vitri.length);
        int vo = getRandom(vong.length);
        int to = vitri[position] + vong[vo];
        RotateAnimation anim = new RotateAnimation(from,to, Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
        anim.setDuration(6000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setFillAfter(true);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                switch (phanthuong[position]){
                    case 1:
                        kq = "bạn được nhân đôi điểm";
                        break;
                    case 2:
                        kq = "bạn mất lượt";
                        break;
                    case 3:
                        kq = "bạn được 1 lần rút thăm may mắn";
                        break;
                    case 4:
                        kq = "bạn bị mất hết điểm";
                         break;
                    case 5:
                        kq = "bạn bị mất lượt";
                        break;
                    case 6:
                        kq = "chia đôi";
                        break;
                    default:
                        kq = "Điểm : " + phanthuong[position];
                        break;
                }
                ketqua.setText(kq);
                from = vitri[position];
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        hinh.startAnimation(anim);
    }
    public int getRandom(int max){
        return (int)(Math.random() * max);
    }
}
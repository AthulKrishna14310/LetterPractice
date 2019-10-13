package com.example.letterpractice;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.crowdfire.cfalertdialog.CFAlertDialog;

public class MainActivity extends AppCompatActivity {

    private Bitmap bitmapScreenShot;
    private int retryCountThreshold = 30;
    private boolean test=false;
    private DrawView drawView;
    private ImageView imageView;
    private Button   finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        drawView=(DrawView)findViewById(R.id.draw_view);
        getSupportActionBar().hide();
        findViewById(R.id.refreshButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        finishButton= findViewById(R.id.hello);

        drawView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_MOVE){

                    if(drawView.isOutIndex()){
                        findViewById(R.id.hello).setBackgroundColor(Color.RED);
                        finishButton.setText("TRACED OUT ");
                    }
                    else
                        {
                        findViewById(R.id.hello).setBackgroundColor(Color.parseColor("#D81B60"));
                        finishButton.setText("CONTINUE TRACING ");
                        }

                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    findViewById(R.id.hello).setBackgroundColor(Color.parseColor("#008577"));
                    finishButton.setText("IF FINISHED CLICK HERE");
                }
                return false;
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawView.count>=7){
                    int mark=10-drawView.wrong;
                         if(mark>6){
                             CFAlertDialog.Builder builder = new CFAlertDialog.Builder(MainActivity.this)
                                     .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                                     .setTitle("Success")
                                     .setIcon(R.drawable.ic_check_circle_black_24dp)
                                     .setMessage("Your score "+mark+"/"+"10"+" .Click to continue" +
                                             " try Your self")
                                     .addButton("Continue", -1, -1,
                                             CFAlertDialog.CFAlertActionStyle.POSITIVE,
                                             CFAlertDialog.CFAlertActionAlignment.END, new DialogInterface.OnClickListener() {
                                                 @Override
                                                 public void onClick(DialogInterface dialog, int which) {
                                                     launchTryUrSelf();
                                                 }
                                             });

                             builder.show();

                         }else {
                             if(mark<0)
                                 mark=0;

                             CFAlertDialog.Builder builder = new CFAlertDialog.Builder(MainActivity.this)
                                     .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                                     .setTitle("Try again")
                                     .setIcon(R.drawable.ic_cancel_black_24dp)
                                     .setMessage("You have traced out .Score= "+mark+"/"+"10")
                                     .addButton("Redo", -1, -1, CFAlertDialog.CFAlertActionStyle.NEGATIVE,
                                             CFAlertDialog.CFAlertActionAlignment.END, new DialogInterface.OnClickListener() {
                                                 @Override
                                                 public void onClick(DialogInterface dialog, int which) {
                                                     recreate();
                                                 }
                                             });

                             builder.show();

                         }
                }else{
                    CFAlertDialog.Builder builder = new CFAlertDialog.Builder(MainActivity.this)
                            .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                            .setTitle("Try again")
                            .setIcon(R.drawable.ic_cancel_black_24dp)
                            .setMessage("Incomplete , Please trace whole letter by touching all " +
                                    "MAGENTA DOTS.")
                            .addButton("Redo", -1, -1, CFAlertDialog.CFAlertActionStyle.NEGATIVE,
                                    CFAlertDialog.CFAlertActionAlignment.END, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            recreate();
                                        }
                                    });

                    builder.show();

                }
            }
        });


      showCFDialogue();
    }

    private void launchTryUrSelf() {

    }


    private void showCFDialogue() {
           CFAlertDialog.Builder builder = new CFAlertDialog.Builder(MainActivity.this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.BOTTOM_SHEET)
                .setTitle("Choose Your letter ")
                .setSingleChoiceItems(new String[]{

                        "A a",
                        "B b",
                        "C c",
                        "D d",
                        "E e",
                        "F f",
                        "G g",
                        "H h",
                        "I i",
                        "J j",
                        "K k",
                        "L l",
                        "M m",
                        "N n",
                        "O o",
                        "P p",
                        "Q q",
                        "R r",
                        "S s",
                        "T t",
                        "U u",
                        "V v",
                        "W w",
                        "X x",
                        "Y y",
                        "Z z"}, 26, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                display("a");
                                dialogInterface.dismiss();

                                break;

                            case 1:
                                display("b");
                                dialogInterface.dismiss();

                                break;
                            case 2:

                                display("c");
                                dialogInterface.dismiss();

                                break;
                            case 3:
                                display("d");
                                dialogInterface.dismiss();

                                break;
                            case 4:
                                display("e");
                                dialogInterface.dismiss();

                                break;

                            case 5:
                                display("f");
                                dialogInterface.dismiss();

                                break;

                            case 6:
                                display("g");
                                dialogInterface.dismiss();

                                break;
                            case 7:

                                display("h");
                                dialogInterface.dismiss();

                                break;
                            case 8:
                                display("i");
                                dialogInterface.dismiss();

                                break;
                            case 9:
                                display("j");
                                dialogInterface.dismiss();

                                break;
                            case 10:
                                display("k");
                                dialogInterface.dismiss();

                                break;

                            case 11:
                                display("l");
                                dialogInterface.dismiss();

                                break;
                            case 12:

                                display("m");
                                dialogInterface.dismiss();

                                break;
                            case 13:
                                display("n");
                                dialogInterface.dismiss();

                                break;
                            case 14:

                                display("o");
                                dialogInterface.dismiss();

                                break;
                            case 15:
                                display("p");
                                dialogInterface.dismiss();

                                break;

                            case 16:
                                display("q");
                                dialogInterface.dismiss();

                                break;
                            case 17:

                                display("r");
                                dialogInterface.dismiss();

                                break;
                            case 18:
                                display("s");
                                dialogInterface.dismiss();

                                break;
                            case 19:
                                display("t");
                                dialogInterface.dismiss();

                                break;
                            case 20:
                                display("u");
                                dialogInterface.dismiss();

                                break;
                            case 21:
                                display("v");
                                dialogInterface.dismiss();

                                break;
                            case 22:
                                display("w");
                                dialogInterface.dismiss();

                                break;

                            case 23:
                                display("x");
                                dialogInterface.dismiss();

                                break;
                            case 24:

                                display("y");
                                dialogInterface.dismiss();

                                break;
                            case 25:
                                display("z");
                                dialogInterface.dismiss();

                                break;
                        }

                    }
                })
                .setDialogBackgroundColor(MainActivity.this.getResources().getColor(R.color.cfdialog_button_white_text_color))
                .setIcon(R.drawable.ic_info_black_24dp)
                .addButton("  CANCEL ", -1, Color.BLUE, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.CENTER, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.show();



    }



        private void display(String letter){
            letter=letter.toLowerCase();
            String name=letter+"_2";
            int resId = this.getResources().getIdentifier(name, "drawable",
                    this.getPackageName());
            drawView.setBackgroundResource(resId);
        }

}

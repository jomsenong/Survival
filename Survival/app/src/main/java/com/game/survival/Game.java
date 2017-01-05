package com.game.survival;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.ThreadLocalRandom;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.min;

/**
 * Created by Ong on 28/12/2016.
 */

public class Game extends AppCompatActivity {
    //Lake,Mountain,Forest,Desert,Plains

    int time = 100;
    int health = 100;
    int warmth = 100;
    int water = 100;
    int food = 100;
    static int x = 25;
    static int y = 25;
    String terrain = "";
    static String map[][] = new String[49][49];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for (int i = 0; i < 49; i++) {
            for (int j = 0; j < 49; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 4 + 1);
                if (randomNum == 0) {
                    terrain = "Lake";
                } else if (randomNum == 1) {
                    terrain = "Mountain";
                } else if (randomNum == 2) {
                    terrain = "Forest";
                } else if (randomNum == 3) {
                    terrain = "Desert";
                } else if (randomNum == 4) {
                    terrain = "Plains";
                }
                map[i][j] = terrain;
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        final ImageView image1 = (ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);
        final ImageView image3 = (ImageView) findViewById(R.id.image3);
        final ImageView image4 = (ImageView) findViewById(R.id.image4);
        final ImageView image5 = (ImageView) findViewById(R.id.image5);
        final ImageView image6 = (ImageView) findViewById(R.id.image6);
        final ImageView image7 = (ImageView) findViewById(R.id.image7);
        final ImageView image8 = (ImageView) findViewById(R.id.image8);
        final ImageView image9 = (ImageView) findViewById(R.id.image9);

        String center = map[x][y];

        generate();
        //When image1 is clicked during the game
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x -= 1;
                y -= 1;
                food -= 5;
                water -= 5;
                time = min(min(health, warmth), min(food, water));

                texting();
                generate();
                dead();
                details();
            }
        });
        //When image2 is clicked during the game
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x -= 1;
                food -= 5;
                water -= 5;
                time = min(min(health, warmth), min(food, water));

                texting();
                generate();
                dead();
                details();
            }
        });
        //When image3 is clicked during the game
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x -= 1;
                y += 1;
                food -= 5;
                water -= 5;
                time = min(min(health, warmth), min(food, water));

                texting();
                generate();
                dead();
                details();
            }
        });
        //When image4 is clicked during the game
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y -= 1;
                food -= 5;
                water -= 5;
                time = min(min(health, warmth), min(food, water));

                texting();
                generate();
                dead();
            }
        });
        //When image6 is clicked during the game
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y += 1;
                food -= 5;
                water -= 5;
                time = min(min(health, warmth), min(food, water));

                texting();
                generate();
                dead();
                details();
            }
        });
        //When image7 is clicked during the game
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x += 1;
                y -= 1;
                food -= 5;
                water -= 5;
                time = min(min(health, warmth), min(food, water));

                texting();
                generate();
                dead();
                details();
            }
        });
        //When image8 is clicked during the game
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x += 1;
                food -= 5;
                water -= 5;
                time = min(min(health, warmth), min(food, water));

                texting();
                generate();
                dead();
                details();
            }
        });
        //When image9 is clicked during the game
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x += 1;
                y += 1;
                food -= 5;
                water -= 5;
                time = min(min(health, warmth), min(food, water));

                texting();
                generate();
                dead();
                details();
            }
        });
    }
    public void generate(){
        final ImageView image1 = (ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);
        final ImageView image3 = (ImageView) findViewById(R.id.image3);
        final ImageView image4 = (ImageView) findViewById(R.id.image4);
        final ImageView image5 = (ImageView) findViewById(R.id.image5);
        final ImageView image6 = (ImageView) findViewById(R.id.image6);
        final ImageView image7 = (ImageView) findViewById(R.id.image7);
        final ImageView image8 = (ImageView) findViewById(R.id.image8);
        final ImageView image9 = (ImageView) findViewById(R.id.image9);

        int counter = 1;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                String land = map[x + i][y + j];
                if (counter == 1) {
                    if (land.equals("Lake")) {
                        image1.setImageDrawable(getResources().getDrawable(R.mipmap.lake, getApplicationContext().getTheme()));
                    } else if (land.equals("Mountain")) {
                        image1.setImageDrawable(getResources().getDrawable(R.mipmap.mountain, getApplicationContext().getTheme()));
                    } else if (land.equals("Forest")) {
                        image1.setImageDrawable(getResources().getDrawable(R.mipmap.forest, getApplicationContext().getTheme()));
                    } else if (land.equals("Plains")) {
                        image1.setImageDrawable(getResources().getDrawable(R.mipmap.plains, getApplicationContext().getTheme()));
                    } else if (land.equals("Desert")) {
                        image1.setImageDrawable(getResources().getDrawable(R.mipmap.desert, getApplicationContext().getTheme()));
                    }
                } else if (counter == 2) {
                    if (land.equals("Lake")) {
                        image2.setImageDrawable(getResources().getDrawable(R.mipmap.lake, getApplicationContext().getTheme()));
                    } else if (land.equals("Mountain")) {
                        image2.setImageDrawable(getResources().getDrawable(R.mipmap.mountain, getApplicationContext().getTheme()));
                    } else if (land.equals("Forest")) {
                        image2.setImageDrawable(getResources().getDrawable(R.mipmap.forest, getApplicationContext().getTheme()));
                    } else if (land.equals("Plains")) {
                        image2.setImageDrawable(getResources().getDrawable(R.mipmap.plains, getApplicationContext().getTheme()));
                    } else if (land.equals("Desert")) {
                        image2.setImageDrawable(getResources().getDrawable(R.mipmap.desert, getApplicationContext().getTheme()));
                    }
                } else if (counter == 3) {
                    if (land.equals("Lake")) {
                        image3.setImageDrawable(getResources().getDrawable(R.mipmap.lake, getApplicationContext().getTheme()));
                    } else if (land.equals("Mountain")) {
                        image3.setImageDrawable(getResources().getDrawable(R.mipmap.mountain, getApplicationContext().getTheme()));
                    } else if (land.equals("Forest")) {
                        image3.setImageDrawable(getResources().getDrawable(R.mipmap.forest, getApplicationContext().getTheme()));
                    } else if (land.equals("Plains")) {
                        image3.setImageDrawable(getResources().getDrawable(R.mipmap.plains, getApplicationContext().getTheme()));
                    } else if (land.equals("Desert")) {
                        image3.setImageDrawable(getResources().getDrawable(R.mipmap.desert, getApplicationContext().getTheme()));
                    }
                } else if (counter == 4) {
                    if (land.equals("Lake")) {
                        image4.setImageDrawable(getResources().getDrawable(R.mipmap.lake, getApplicationContext().getTheme()));
                    } else if (land.equals("Mountain")) {
                        image4.setImageDrawable(getResources().getDrawable(R.mipmap.mountain, getApplicationContext().getTheme()));
                    } else if (land.equals("Forest")) {
                        image4.setImageDrawable(getResources().getDrawable(R.mipmap.forest, getApplicationContext().getTheme()));
                    } else if (land.equals("Plains")) {
                        image4.setImageDrawable(getResources().getDrawable(R.mipmap.plains, getApplicationContext().getTheme()));
                    } else if (land.equals("Desert")) {
                        image4.setImageDrawable(getResources().getDrawable(R.mipmap.desert, getApplicationContext().getTheme()));
                    }
                } else if (counter == 5) {
                    if (land.equals("Lake")) {
                        image5.setImageDrawable(getResources().getDrawable(R.mipmap.lake, getApplicationContext().getTheme()));
                    } else if (land.equals("Mountain")) {
                        image5.setImageDrawable(getResources().getDrawable(R.mipmap.mountain, getApplicationContext().getTheme()));
                    } else if (land.equals("Forest")) {
                        image5.setImageDrawable(getResources().getDrawable(R.mipmap.forest, getApplicationContext().getTheme()));
                    } else if (land.equals("Plains")) {
                        image5.setImageDrawable(getResources().getDrawable(R.mipmap.plains, getApplicationContext().getTheme()));
                    } else if (land.equals("Desert")) {
                        image5.setImageDrawable(getResources().getDrawable(R.mipmap.desert, getApplicationContext().getTheme()));
                    }
                } else if (counter == 6) {
                    if (land.equals("Lake")) {
                        image6.setImageDrawable(getResources().getDrawable(R.mipmap.lake, getApplicationContext().getTheme()));
                    } else if (land.equals("Mountain")) {
                        image6.setImageDrawable(getResources().getDrawable(R.mipmap.mountain, getApplicationContext().getTheme()));
                    } else if (land.equals("Forest")) {
                        image6.setImageDrawable(getResources().getDrawable(R.mipmap.forest, getApplicationContext().getTheme()));
                    } else if (land.equals("Plains")) {
                        image6.setImageDrawable(getResources().getDrawable(R.mipmap.plains, getApplicationContext().getTheme()));
                    } else if (land.equals("Desert")) {
                        image6.setImageDrawable(getResources().getDrawable(R.mipmap.desert, getApplicationContext().getTheme()));
                    }
                } else if (counter == 7) {
                    if (land.equals("Lake")) {
                        image7.setImageDrawable(getResources().getDrawable(R.mipmap.lake, getApplicationContext().getTheme()));
                    } else if (land.equals("Mountain")) {
                        image7.setImageDrawable(getResources().getDrawable(R.mipmap.mountain, getApplicationContext().getTheme()));
                    } else if (land.equals("Forest")) {
                        image7.setImageDrawable(getResources().getDrawable(R.mipmap.forest, getApplicationContext().getTheme()));
                    } else if (land.equals("Plains")) {
                        image7.setImageDrawable(getResources().getDrawable(R.mipmap.plains, getApplicationContext().getTheme()));
                    } else if (land.equals("Desert")) {
                        image7.setImageDrawable(getResources().getDrawable(R.mipmap.desert, getApplicationContext().getTheme()));
                    }
                } else if (counter == 8) {
                    if (land.equals("Lake")) {
                        image8.setImageDrawable(getResources().getDrawable(R.mipmap.lake, getApplicationContext().getTheme()));
                    } else if (land.equals("Mountain")) {
                        image8.setImageDrawable(getResources().getDrawable(R.mipmap.mountain, getApplicationContext().getTheme()));
                    } else if (land.equals("Forest")) {
                        image8.setImageDrawable(getResources().getDrawable(R.mipmap.forest, getApplicationContext().getTheme()));
                    } else if (land.equals("Plains")) {
                        image8.setImageDrawable(getResources().getDrawable(R.mipmap.plains, getApplicationContext().getTheme()));
                    } else if (land.equals("Desert")) {
                        image8.setImageDrawable(getResources().getDrawable(R.mipmap.desert, getApplicationContext().getTheme()));
                    }
                } else if (counter == 9) {
                    if (land.equals("Lake")) {
                        image9.setImageDrawable(getResources().getDrawable(R.mipmap.lake, getApplicationContext().getTheme()));
                    } else if (land.equals("Mountain")) {
                        image9.setImageDrawable(getResources().getDrawable(R.mipmap.mountain, getApplicationContext().getTheme()));
                    } else if (land.equals("Forest")) {
                        image9.setImageDrawable(getResources().getDrawable(R.mipmap.forest, getApplicationContext().getTheme()));
                    } else if (land.equals("Plains")) {
                        image9.setImageDrawable(getResources().getDrawable(R.mipmap.plains, getApplicationContext().getTheme()));
                    } else if (land.equals("Desert")) {
                        image9.setImageDrawable(getResources().getDrawable(R.mipmap.desert, getApplicationContext().getTheme()));
                    }
                }
                counter++;
            }
        }
    }

    public void dead(){
        final Intent intent = new Intent(this, Game.class);
        if (time <= 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
            builder.setTitle("Game Over");
            builder.setNeutralButton("New Game", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked new game button
                    finish();
                    Toast.makeText(getApplicationContext(), "Populating a new map...", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked the exit button
                    Toast.makeText(getApplicationContext(), "Exiting...", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }
    }

    public void texting(){
        final TextView tv0 = (TextView) findViewById(R.id.text0); //time
        final TextView tv1 = (TextView) findViewById(R.id.text1); //health
        final TextView tv2 = (TextView) findViewById(R.id.text2); //warmth
        final TextView tv3 = (TextView) findViewById(R.id.text3); //water
        final TextView tv4 = (TextView) findViewById(R.id.text4); //food

        tv0.setText("Time: " + time + "/100");
        tv1.setText("Health: " + health + "/100");
        tv2.setText("Warmth: " + warmth + "/100");
        tv3.setText("Water: " + water + "/100");
        tv4.setText("Food: " + food + "/100");
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
        builder.setTitle("Quit the game?");
        builder.setNeutralButton("Resume", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked new game button
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the exit button
                Toast.makeText(getApplicationContext(), "Exiting...",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void details(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
        String location = map[x][y];
        String message = "";
        builder.setTitle("Location: " + location);
        if(location.equals("Mountain")){
            message = "Food - 5, water - 5, warmth will - 5 for every action in this area";
        }
        else if(location.equals("Lake")){
            message = "Food -5, water to max, warmth will -5 for every action in this area";
        }
        else if(location.equals("Forest")){
            message = "Food -5, water -5, warmth will increase for every action in this area";
        }
        else if(location.equals("Plains")){
            message = "Food -5, water -5, warmth will increase for every action in this area";
        }
        else if(location.equals("Desert")){
            message = "Food -5, water -10, warmth will increase for every action in this area";
        }
        builder.setMessage(message);
        builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked new game button
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

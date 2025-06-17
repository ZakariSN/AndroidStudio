package com.example.android_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Random;

public class Smo extends AppCompatActivity {

    private TextView messageText;
    private Button nextProButton;
    private Button showConsButton;
    private ImageView heartImage;
    private ArrayList<String> prosList;
    private ArrayList<String> consList;
    private Random random;
    private boolean showingPros = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smo);

        // Initialize UI elements
        messageText = findViewById(R.id.message_text);
        nextProButton = findViewById(R.id.next_pro_button);
        showConsButton = findViewById(R.id.show_cons_button);
        heartImage = findViewById(R.id.heart_image);

        // Initialize random object
        random = new Random();

        // Setup animations
        final Animation heartBeat = AnimationUtils.loadAnimation(this, R.anim.heartbeat);

        // Initialize lists
        initializeLists();

        // Show a random pro to start
        showRandomPro();

        // Set up button listeners
        nextProButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heartImage.startAnimation(heartBeat);
                if (showingPros) {
                    showRandomPro();
                } else {
                    showingPros = true;
                    nextProButton.setText("Next Reason I Love You");
                    showRandomPro();
                }
            }
        });

        showConsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heartImage.startAnimation(heartBeat);
                if (showingPros) {
                    showingPros = false;
                    nextProButton.setText("Back to Reasons I Love You");
                    showRandomCon();
                } else {
                    showingPros = true;
                    nextProButton.setText("Next Reason I Love You");
                    showRandomPro();
                }
            }
        });
    }

    private void initializeLists() {
        prosList = new ArrayList<>();
        // Adding all pros
        prosList.add("You are smol and that's adorable");
        prosList.add("You are very cute");
        prosList.add("You are horny(sometimes)");
        prosList.add("All your actions are comical");
        prosList.add("You make cute faces");
        prosList.add("You are very dedicated to your work");
        prosList.add("You make me happy by just being with me");
        prosList.add("You stress over smol things (like you) but in the end do good (you should definitely believe in yourself more)");
        prosList.add("You like food like me");
        prosList.add("You find me cute when I eat even when I'm a very messy eater");
        prosList.add("You are funny (sometimes)");
        prosList.add("You let me touch your thighs (pillows)");
        prosList.add("You think you are fast and stronk but in the end you are a smol");
        prosList.add("You have helped me to become a better person who goes to college");
        prosList.add("You have helped me to be more happy with myself");
        prosList.add("You like bun maska so much and make such cute faces while eating it");
        prosList.add("You have a skibidi lil brother");
        prosList.add("You forgive me");
        prosList.add("Your hair smells good");
        prosList.add("Your waist is so grabbable");
        prosList.add("You are so soft");
        prosList.add("You let me come to your house and eep");
        prosList.add("Your angry face is hot");
        prosList.add("Your butt is perfect");
        prosList.add("Your boobies are beautiful");
        prosList.add("YOUR THIGHS are amazing");
        prosList.add("Your smile is so bright");
        prosList.add("At heart you are a kiddo");
        prosList.add("You share intimate moments with me");
        prosList.add("I love your body odor (yes I do)");
        prosList.add("You share your food with me");
        prosList.add("Your bites and sips are so smol (like you)");
        prosList.add("You keep cold water for me");
        prosList.add("You let me scrub you");
        prosList.add("You get excited when something good happens to me");
        prosList.add("You are very strong");
        prosList.add("I like your smooth brain (hehe)");
        prosList.add("You laugh at all my jokes");
        prosList.add("You get my autism so I can be myself around you");
        prosList.add("You share special moments with me");
        prosList.add("You make me food and don't mind feeding it to me");
        prosList.add("You look amazing all the time");
        prosList.add("You sit on my lap like you also want to");
        prosList.add("You apply sunscreen on my face :)");
        prosList.add("You wash my hair when I ask you to");
        prosList.add("You are kinda my motivation and reason to get through the day");
        prosList.add("You hit me and think you are stronk");
        prosList.add("You let me pick you up and throw you around");
        prosList.add("You look adorable in traditional (wear more pls)");
        prosList.add("I LOVE MY SMOL");

        consList = new ArrayList<>();
        // Adding the single con
        consList.add("You have stupid toes :((( (but I love you anyway)");
    }

    private void showRandomPro() {
        int index = random.nextInt(prosList.size());
        messageText.setText(prosList.get(index));
    }

    private void showRandomCon() {
        // Since there's only one con, just show it
        messageText.setText(consList.get(0));
    }
}
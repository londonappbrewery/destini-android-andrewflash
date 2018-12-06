package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mStoryTextView;

    int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mStoryTextView = findViewById(R.id.storyTextView);

        if(savedInstanceState == null) {
            mStoryIndex = 1;
        } else {
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
            updateStory();
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex == 1) {
                    mStoryIndex = 3;
                } else if(mStoryIndex == 2) {
                    mStoryIndex = 3;
                } else if(mStoryIndex == 3) {
                    mStoryIndex = 6;
                } else {
                    mStoryIndex = 1;
                }
                updateStory();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mStoryIndex == 1) {
                    mStoryIndex = 2;
                } else if(mStoryIndex == 2) {
                    mStoryIndex = 4;
                } else if(mStoryIndex == 3) {
                    mStoryIndex = 5;
                } else {
                    mStoryIndex = 1;
                }
                updateStory();
            }
        });

    }

    private void updateStory() {
        if (mStoryIndex == 1) {
            mStoryTextView.setText(R.string.T1_Story);
            mButtonTop.setText(R.string.T1_Ans1);
            mButtonBottom.setText(R.string.T1_Ans2);
        } else if (mStoryIndex == 2) {
            mStoryTextView.setText(R.string.T2_Story);
            mButtonTop.setText(R.string.T2_Ans1);
            mButtonBottom.setText(R.string.T2_Ans2);
        } else if (mStoryIndex == 3) {
            mStoryTextView.setText(R.string.T3_Story);
            mButtonTop.setText(R.string.T3_Ans1);
            mButtonBottom.setText(R.string.T3_Ans2);
        } else if (mStoryIndex == 4) {
            mStoryTextView.setText(R.string.T4_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        } else if (mStoryIndex == 5) {
            mStoryTextView.setText(R.string.T5_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        } else if (mStoryIndex == 6) {
            mStoryTextView.setText(R.string.T6_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        } else {
            mStoryTextView.setText(R.string.T1_Story);
            mButtonTop.setText(R.string.T1_Ans1);
            mButtonBottom.setText(R.string.T1_Ans2);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndex", mStoryIndex);
    }
}

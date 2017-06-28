package com.example.kathleengay.nxmgridsquares;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kathleengay.nxmgridsquares.squares.SquareCounter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_SQUARES_VISIBLE = 7;

    private EditText nView, mView;
    private TextView answerView;
    private GridLayout grid;
    private int currentN, currentM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerView = (TextView) findViewById(R.id.main_tv_answer);
        nView = (EditText) findViewById(R.id.main_et_width);
        mView = (EditText) findViewById(R.id.main_et_height);
        grid = (GridLayout) findViewById(R.id.main_gl_grid_container);

        grid.setColumnOrderPreserved(false);
        grid.setRowOrderPreserved(false);

        final Context context = getApplicationContext();
        nView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    int newN;
                    try {
                        newN = Integer.valueOf(s.toString());
                        updateN(newN);
                    } catch (NumberFormatException e) {
                        Toast.makeText(context, "Not a number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        mView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    int newM;
                    try {
                        newM = Integer.valueOf(s.toString());
                        updateM(newM);
                    } catch (NumberFormatException e) {
                        Toast.makeText(context, "Not a number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void updateN(int newN) {
        this.currentN = newN;
        updateGrid();
        updateAnswer();
    }

    private void updateM(int newM) {
        this.currentM = newM;
        updateAnswer();
        updateGrid();
    }

    private void updateGrid() {
        if (currentN > 0 && currentM > 0 && currentN <= MAX_SQUARES_VISIBLE && currentM <= MAX_SQUARES_VISIBLE) {
            int gridSquares = grid.getChildCount();
            int squareSize = getResources().getDimensionPixelSize(R.dimen.square_size);
            final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(squareSize, squareSize);

            int gridCol = grid.getColumnCount();
            int gridRow = grid.getRowCount();
            int newSquaresCount = currentN * currentM;

            if (gridSquares < newSquaresCount) {
                grid.setColumnCount(currentN);
                grid.setRowCount(currentM);

                int squaresToAdd = newSquaresCount - gridSquares;
                for (int i = 1; i <= squaresToAdd; i++) {
                    grid.addView(createSquare(layoutParams));
                }
            } else if (gridSquares > newSquaresCount) {
                int lastRow = currentM < gridRow ? currentM : 0;
                int lastCol = currentN < gridCol ? currentN : 0;

                for (int row = gridRow - 1; row >= lastRow; row--) {
                    for (int col = gridCol - 1; col >= lastCol; col--) {
                        grid.removeViewAt(row * gridCol + col);
                    }
                }
            }

            Log.e("this", "N count : " + grid.getColumnCount());
            Log.e("this", "M count : " + grid.getRowCount());
            Log.e("this", "Remaining child views : " + grid.getChildCount());
            grid.setColumnCount(currentN);
            grid.setRowCount(currentM);
        }
    }

    private ImageView createSquare(ViewGroup.LayoutParams layoutParams) {
        ImageView square = new ImageView(this);
        square.setImageResource(R.drawable.rectangle);
        square.setLayoutParams(layoutParams);

        return square;
    }

    private void updateAnswer() {
        if (currentN > 0 && currentM > 0) {
            String correctAnswer = String.valueOf(SquareCounter.countSquares(currentN, currentM));
            answerView.setText(correctAnswer);
        }
    }
}
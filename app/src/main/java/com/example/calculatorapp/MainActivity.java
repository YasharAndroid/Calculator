package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button btnAc, btnDel, btnPlus, btnMinus, btnDivide, btnMulti, btnEqual, btnDot;
    private TextView tvResult, tvHistory;


    private String number = null;
    double firstNumber = 0, lastNumber = 0;


    String status = null;
    boolean operator = false;

    DecimalFormat formatter = new DecimalFormat("######.######");


    String history, currentResult;


    boolean dot = true;


    boolean btnAcControl = true;


    boolean btnEqualsControl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAc = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMulti = findViewById(R.id.btnMulti);
        btnEqual = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);

        tvHistory = findViewById(R.id.txtViewHistory);
        tvResult = findViewById(R.id.txtViewResult);

        /**
         *
         */
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClicked("9");
            }
        });
        /**
         *
         */
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = null;
                status = null;
                tvResult.setText("0");
                tvHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
                dot = true;
                btnAcControl = true;
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnAcControl) {
                    tvResult.setText("0");
                } else {
                    number = number.substring(0, number.length() - 1);
                    if (number.length() == 0) {
                        btnDel.setClickable(false);
                    } else dot = !number.contains(".");
                    tvResult.setText(number);
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = tvHistory.getText().toString();
                currentResult = tvResult.getText().toString();
                tvHistory.setText(history + currentResult + "+");
                if (operator) {
                    if (status == "multiplication") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "subtraction") {
                        minus();
                    } else {
                        plus();
                    }
                }

                status = "sum";
                operator = false;
                number = null;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = tvHistory.getText().toString();
                currentResult = tvResult.getText().toString();
                tvHistory.setText(history + currentResult + "-");
                if (operator) {
                    if (status == "multiplication") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "sum") {
                        plus();
                    } else {
                        minus();
                    }
                }

                status = "subtraction";
                operator = false;
                number = null;
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = tvHistory.getText().toString();
                currentResult = tvResult.getText().toString();
                tvHistory.setText(history + currentResult + "*");
                if (operator) {
                    if (status == "sum") {
                        plus();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "subtraction") {
                        minus();
                    } else {
                        multiply();
                    }
                }

                status = "multiplication";
                operator = false;
                number = null;
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = tvHistory.getText().toString();
                currentResult = tvResult.getText().toString();
                tvHistory.setText(history + currentResult + "/");
                if (operator) {
                    if (status == "sum") {
                        plus();
                    } else if (status == "multiplication") {
                        multiply();
                    } else if (status == "subtraction") {
                        minus();
                    } else {
                        divide();
                    }
                }

                status = "division";
                operator = false;
                number = null;
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator) {
                    if (status == "sum") {
                        plus();
                    } else if (status == "subtraction") {
                        minus();
                    } else if (status == "multiplication") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    }
                } else {
                    firstNumber = Double.parseDouble(tvResult.getText().toString());
                }
                operator = false;
                btnEqualsControl = true;
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dot) {
                    if (number == null) {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                }

                tvResult.setText(number);
                dot = false;
            }
        });

    }

    /**
     * @param view
     */
    public void numberClicked(String view) {
        if (number == null) {
            number = view;
        } else if (btnEqualsControl) {
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        } else {
            number = number + view;
        }
        tvResult.setText(number);
        operator = true;
        btnAcControl = false;
        btnDel.setClickable(true);
        btnEqualsControl = false;
    }

    public void plus() {
        lastNumber = Double.parseDouble(tvResult.getText().toString());
        firstNumber = firstNumber + lastNumber;
        tvResult.setText(formatter.format(firstNumber));
        dot = true;
    }

    public void minus() {
        if (firstNumber == 0) {
            firstNumber = Double.parseDouble(tvResult.getText().toString());
        } else {
            lastNumber = Double.parseDouble(tvResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        tvResult.setText(formatter.format(firstNumber));
        dot = true;
    }

    public void multiply() {
        if (firstNumber == 0) {
            firstNumber = 1;
        }
        lastNumber = Double.parseDouble(tvResult.getText().toString());
        firstNumber = firstNumber * lastNumber;

        tvResult.setText(formatter.format(firstNumber));
        dot = true;
    }

    public void divide() {
        if (firstNumber == 0) {
            lastNumber = Double.parseDouble(tvResult.getText().toString());
            firstNumber = lastNumber;
        } else {
            lastNumber = Double.parseDouble(tvResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        tvResult.setText(formatter.format(firstNumber));
        dot = true;
    }
}
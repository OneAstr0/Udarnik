package com.example.udarnik_alp01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private TextView outputTextView1, outputTextView2, outputWordTextView, score, scoreVision, infModeAttention;
    private Button wordFirstButton, wordSecondButton, btnReset, btnRestart, btnMenu;

    private Dialog endGameDialog;

    private int currentRound = 0;

    public int scoreValue = 0;

    String[][] words = new String[][]{
            {"АЭРОПОРТЫ", "аэропОрты", "аэропортЫ"},
            {"БАНТЫ", "бАнты", "бантЫ"},
            {"БУХГАЛТЕРОВ", "бухгАлтеров", "бухгалтерОв"},
            {"ВЕРОИСПОВЕДАНИЕ", "вероисповЕдание", "вероисповедАние"},
            {"ВОДОПРОВОД", "водопровОд", "водопрОвод"},
            {"ГАЗОПРОВОД", "газопровОд", "газопрОвод"},
            {"ГРАЖДАНСТВО", "граждАнство", "грАжданство"},
            {"ДЕФИС", "дефИс", "дЕфис"},
            {"ДЕШЕВИЗНА", "дешевИзна", "дешевизнА"},
            {"ДИСПАНСЕР", "диспансЕр", "диспАнсер"},
            {"ДОГОВОРЁННОСТЬ", "договорЕнность", "договОренность"},
            {"ДОКУМЕНТ", "докумЕнт", "докУмент"},
            {"ДОСУГ", "досУг", "дОсуг"},
            {"ЕРЕТИК", "еретИк", "ерЕтик"},
            {"ЖАЛЮЗИ", "жалюзИ", "жАлюзи"},
            {"ЗНАЧИМОСТЬ", "знАчимость", "значИмость"},
            {"ИКСЫ", "Иксы", "иксЫ"},
            {"КАТАЛОГ", "каталОг", "катАлог"},
            {"КВАРТАЛ", "квартАл", "квАртал"},
            {"КИЛОМЕТР", "киломЕтр", "килОметр"},
            {"КОНУСОВ", "кОнусов", "конусОв"},
            {"КОРЫСТЬ", "корЫсть", "кОрысть"},
            {"КРАНЫ", "крАны", "кранЫ"},
            {"КРЕМЕНЬ", "кремЕнь", "крЕмень"},
            {"ЛЕКТОРОВ", "лЕкторов", "лекторОв"},
            {"ЛОКТЯ", "лОктя", "локтЯ"},
            {"ЛЫЖНЯ", "лыжнЯ", "лЫжня"},
            {"МЕСТНОСТЕЙ", "мЕстностей", "местностЕй"},
            {"НАМЕРЕНИЕ", "намЕрение", "намерЕние"},
            {"НАРОСТ", "нарОст", "нАрост"},
            {"НЕДРУГ", "нЕдруг", "недрУг"},
            {"НЕДУГ", "недУг", "нЕдуг"},
            {"НЕКРОЛОГ", "некролОг", "некрОлог"},
            {"НЕНАВИСТЬ", "нЕнависть", "ненАвисть"},
            {"НЕФТЕПРОВОД", "нефтепровОд", "нефтепрОвод"},
            {"НОВОСТЕЙ", "новостЕй", "нОвостей"},
            {"НОГТЯ", "нОгтя", "ногтЯ"},
            {"ОТРОЧЕСТВО", "Отрочество", "отрОчество"},
            {"ПАРТЕР", "партЕр", "пАртер"},
            {"ПОРТФЕЛЬ", "портфЕль", "пОртфель"},
            {"ПОРУЧНИ", "пОручни", "порУчни"},
            {"ПРИДАНОЕ", "придАное", "прИданое"},
            {"ПРИЗЫВ", "призЫв", "прИзыв"},
            {"СВЕКЛА", "свЕкла", "свеклА"},
            {"СИРОТЫ", "сирОты", "сИроты"},
            {"СОЗЫВ", "созЫв", "сОзыв"},
            {"СОСРЕДОТОЧЕНИЕ", "сосредотОчение", "сосредоточЕние"},
            {"СРЕДСТВА", "срЕдства", "средствА"},
            {"СТАТУЯ", "стАтуя", "статУя"},
            {"СТОЛЯР", "столЯр", "стОляр"},
            {"ТАМОЖНЯ", "тамОжня", "тАможня"},
            {"ТОРТЫ", "тОрты", "тортЫ"},
            {"ТУФЛЯ", "тУфля", "туфлЯ"},
            {"ЦЕМЕНТ", "цемЕнт", "цЕмент"},
            {"ЦЕНТНЕР", "цЕнтрер", "центнЕр"},
            {"ЦЕПОЧКА", "цепОчка", "цЕпочка"},
            {"ШАРФЫ", "шАрфы", "шарфЫ"},
            {"ШОФЕР", "шофЕр", "шОфер"},
            {"ЭКСПЕРТ", "экспЕрт", "Эксперт"},
            {"ВЕРНА", "вернА", "вЕрна"},
            {"ЗНАЧИМЫЙ", "знАчимый", "значИмый"},
            {"КРАСИВЕЕ", "красИвее", "красивЕе"},
            {"КРАСИВЕЙШИЙ", "красИвейший", "красивЕйший"},
            {"КУХОННЫЙ", "кУхонный", "кухОнный"},
            {"ЛОВКА", "ловкА", "лОвка"},
            {"МОЗАИЧНЫЙ", "мозаИчный", "мозАичный"},
            {"ОПТОВЫЙ", "оптОвый", "Оптовый"},
            {"ПРОЗОРЛИВЫЙ", "прозорлИвый", "прозОрливый"},
            {"ПРОЗОРЛИВА", "прозорлИва", "прозОрливый"},
            {"СЛИВОВЫЙ", "слИвовый", "сливОвый"},
            {"БРАЛА", "бралА", "брАла"},
            {"БРАЛАСЬ", "бралАсь", "брАлась"},
            {"ВЗЯЛА", "взялА", "взЯла"},
            {"ВЗЯЛАСЬ", "взялАсь", "взЯлась"},
            {"ВЛИЛАСЬ", "влилАсь", "влИлась"},
            {"ВОРВАЛАСЬ", "ворвалАсь", "ворвАлась"},
            {"ВОСПРИНЯТЬ", "воспринЯть", "воспрИнять"},
            {"ВОССОЗДАЛА", "воссоздалА", "воссОздала"},
            {"ВРУЧИТ", "вручИт", "врУчит"},
            {"ГНАЛА", "гналА", "гнАла"},
            {"ГНАЛАСЬ", "гналАсь", "гнАлась"},
            {"ДОБРАЛА", "добралА", "добрАла"},
            {"ДОБРАЛАСЬ", "добралАсь", "добрАлась"},
            {"ДОЖДАЛАСЬ", "дождалАсь", "дождАлась"},
            {"ДОЗВОНИТЬСЯ", "дозвонИться", "дозвОниться"},
            {"ДОЗИРОВАТЬ", "дозИровать", "дозировАть"},
            {"ЖДАЛА", "ждалА", "ждАла"},
            {"ЖИЛОСЬ", "жилОсь", "жИлось"},
            {"ЗАКУПОРИТЬ", "закУпорить", "закупОрить"},
            {"ЗАНЯТЬ", "занЯть", "зАнять"},
            {"ЗАПЕРЛА", "заперлА", "зАперла"},
            {"ЗАПЛОМБИРОВАТЬ", "запломбировАть", "запломбИровать"},
            {"ЗАЩЕМИТ", "защемИт", "защЕмит"},
            {"ЗВАЛА", "звалА", "звАла"},
            {"ЗВОНИТ", "звонИт", "звОнит"},
            {"ЗВОНИТЬ", "звонИть", "звОнить"},
            {"КАШЛЯНУТЬ", "кАшлянуть", "кашлянУть"},
            {"КЛАЛА", "клАла", "клалА"},
            {"КЛЕИТЬ", "клЕить", "клеИть"},
            {"КРАЛАСЬ", "крАлась", "кралАсь"},
            {"КРОВОТОЧИТЬ", "кровоточИть", "кровотОчить"},
            {"ЛГАЛА", "лгалА", "лгАла"},
            {"ЛИЛА", "лилА", "лИла"},
            {"ЛИЛАСЬ", "лилАсь", "лИлась"},
            {"НАВРАЛА", "навралА", "наврАла"},
            {"НАДЕЛИТ", "наделИт", "надЕлит"},
            {"НАДОРВАЛАСЬ", "надорвалАсь", "надорвАлась"},
            {"НАЗВАЛАСЬ", "назвалАсь", "назвАлась"},
            {"НАЗВАТЬСЯ", "назвАться", "нАзваться"},
            {"НАКРЕНИТСЯ", "накренИтся", "накрЕнится"},
            {"НАКРЕНИТЬСЯ", "накренИться", "накрЕниться"},
            {"НАЛИЛА", "налилА", "налИла"},
            {"НАРВАЛА", "нарвалА", "нарвАла"},
            {"НАЧАТЬ", "начАть", "нАчать"},
            {"ОБЗВОНИТ", "обзвонИт", "обзвОнит"},
            {"ОБЛЕГЧИТЬ", "облегчИть", "облЕгчить"},
            {"ОБЛИЛАСЬ", "облилАсь", "облИлась"},
            {"ОБНЯЛАСЬ", "обнялАсь", "обнЯлась"},
            {"ОБОГНАЛА", "обогналА", "обогнАла"},
            {"ОБОДРАЛА", "ободралА", "ободрАла"},
            {"ОБОДРИТ", "ободрИт", "обОдрит"},
            {"ОБОСТРИТЬ", "обострИть", "обОстрить"},
            {"ОДОЛЖИТЬ", "одолжИть", "одОлжить"},
            {"ОЗЛОБИТЬ", "озлОбить", "озлобИть"},
            {"ОКЛЕИТЬ", "оклЕить", "оклеИть"},
            {"ОКРУЖИТ", "окружИт", "окрУжит"},
            {"ОПОШЛИТЬ", "опОшлить", "опошлИть"},
            {"ОСВЕДОМИТЬСЯ", "освЕдомиться", "осведомИться"},
            {"ОТБЫЛА", "отбылА", "отбЫла"},
            {"ОТДАЛА", "отдалА", "отдАла"},
            {"ОТКУПОРИТЬ", "откУпорить", "откупОрить"},
            {"ОТОЗВАЛА", "отозвалА", "отозвАла"},
            {"ОТОЗВАЛАСЬ", "отозвалАсь", "отозвАлась"},
            {"ПЕРЕЗВОНИТ", "перезвонИт", "перезвОнит"},
            {"ПЕРЕЛИЛА", "перелилА", "перелИла"},
            {"ПЛОДОНОСИТЬ", "плодоносИть", "плодонОсить"},
            {"ПЛОМБИРОВАТЬ", "пломбировАть", "пломбИровать"},
            {"ПОВТОРИТ", "повторИт", "повтОрит"},
            {"ПОЗВАЛА", "позвалА", "позвАла"},
            {"ПОЗВОНИТ", "позвонИт", "позвОнит"},
            {"ПОЛИЛА", "полилА", "полИла"},
            {"ПОЛОЖИЛ", "положИл", "полОжил"},
            {"ПОНЯЛА", "понялА", "пОняла"},
            {"ПОСЛАЛА", "послАла", "послалА"},
            {"ПРИБЫТЬ", "прибЫть", "прИбыть"},
            {"ПРИБЫЛ", "прИбыл", "прибЫл"},
            {"ПРИНЯЛ", "прИнял", "принЯл"},
            {"РВАЛА", "рвалА", "рвАла"},
            {"СВЕРЛИТ", "сверлИт", "свЕрлит"},
            {"СНЯЛА", "снялА", "снЯла"},
            {"СОВРАЛА", "совралА", "соврАла"},
            {"СОЗДАЛА", "создалА", "создАла"},
            {"СОРВАЛА", "сорвалА", "сорвАла"},
            {"СОРИТ", "сорИт", "сОрит"},
            {"УБРАЛА", "убралА", "убрАла"},
            {"УГЛУБИТЬ", "углубИть", "углУбить"},
            {"УКРЕПИТ", "укрепИт", "укрЕпит"},
            {"ЧЕРПАТЬ", "чЕрпать", "черпАть"},
            {"ЩЕМИТ", "щемИт", "щЕмит"},
            {"ЩЕЛКАТЬ", "щЕлкать", "щелкАть"},
            {"ЗАГНУТЫЙ", "зАгнутый", "загнУтый"},
            {"ЗАНЯТЫЙ", "зАнятый", "занЯтый"},
            {"ЗАСЕЛЕНА", "заселенА", "засЕлена"},
            {"КОРМЯЩИЙ", "кормЯщий", "кОрмящий"},
            {"КРОВОТОЧАЩИЙ", "кровоточАщий", "кровотОчащий"},
            {"НАЖИВШИЙ", "нажИвший", "нАживший"},
            {"НАЛИВШИЙ", "налИвший", "нАливший"},
            {"НАНЯВШИЙСЯ", "нанЯвшийся", "нАнявшийся"},
            {"НАЧАТЫЙ", "нАчатый", "начАтый"},
            {"НИЗВЕДЕННЫЙ", "низведЕнный", "низвЕденный"},
            {"ОБЛЕГЧЕННЫЙ", "облегчЕнный", "облЕгченный"},
            {"ОБОДРЕННЫЙ", "ободрЕнный", "обОдренный"},
            {"ОБОСТРЕННЫЙ", "обострЕнный", "обОстренный"},
            {"ОТКЛЮЧЕННЫЙ", "отключЕнный", "отклЮченный"},
            {"ПОВТОРЕННЫЙ", "повторЕнный", "повтОренный"},
            {"ПОДЕЛЕННЫЙ", "поделЕнный", "подЕленный"},
            {"ПОНЯВШИЙ", "понЯвший", "пОнявший"},
            {"ПРИНЯТА", "принятА", "прИнята"},
            {"ПРИРУЧЕННЫЙ", "приручЕнный", "прирУченный"},
            {"ПРОЖИВШИЙ", "прожИвший", "прОживший"},
            {"СНЯТА", "снятА", "снЯта"},
            {"СОГНУТЫЙ", "сОгнутый", "согнУтый"},
            {"УГЛУБЛЕННЫЙ", "углублЕнный", "углУбленный"},
            {"ЗАКУПОРИВ", "закУпорив", "закупОрив"},
            {"ОТДАВ", "отдАв", "Отдав"},
            {"ПОДНЯВ", "поднЯв", "пОдняв"},
            {"ПРИБЫВ", "прибЫв", "прИбыв"},
            {"СОЗДАВ", "создАв", "сОздав"},
            {"ВОВРЕМЯ", "вОвремя", "воврЕмя"},
            {"ДОВЕРХУ", "дОверху", "довЕрху"},
            {"ДОНЕЛЬЗЯ", "донЕльзя", "дОнельзя"},
            {"ДОНИЗУ", "дОнизу", "донИзу"},
            {"ДОСУХА", "дОсуха", "досУха"},
            {"ЗАСВЕТЛО", "зАсветло ", "засвЕтло"},
            {"ЗАТЕМНО", "зАтемно", "затЕмно"},
            {"КРАСИВЕЕ", "красИвее", "красивЕе"},
            {"НАДОЛГО", "надОлго", "нАдолго"},
            {"НЕНАДОЛГО", "ненадОлго", "ненАдолго"},
            {"ПЕРЧИТЬ", "перчИть", "пЕрчить"},
            {"ИКОНОПИСЬ", "Иконопись", "икОнопись"},
            {"ПРИНУДИТЬ", "принУдить", "принудИть"}
    };


    private List<String[]> remainingWords;

    private String correct;

    boolean infinityGame = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        SharedPreferences sharedPreferences = getSharedPreferences(SettingsActivity.SHARED_PREFS, MODE_PRIVATE);
        infinityGame = sharedPreferences.getBoolean(SettingsActivity.INFINITY_GAME, false);

        score = findViewById(R.id.score);
        btnReset = findViewById(R.id.btnReset);
        outputTextView1 = findViewById(R.id.output);
        outputTextView2 = findViewById(R.id.output2);
        outputWordTextView = findViewById(R.id.outputWord);
        wordFirstButton = findViewById(R.id.btnWordFirst);
        wordSecondButton = findViewById(R.id.btnWordSecond);
        scoreVision =  findViewById(R.id.scoreVision);
        infModeAttention = findViewById(R.id.infModeAttention);

        // Создание диалогового окна
        endGameDialog = new Dialog(this);
        endGameDialog.setContentView(R.layout.end_game_overlay);
        endGameDialog.setCancelable(false);
        btnMenu = findViewById(R.id.btnMenu);
        btnRestart = findViewById(R.id.btnRestart);


        // ставлю стандартное значение для счёта - 0
        if (infinityGame == false) {
            score.setText(String.valueOf(scoreValue) + " из " + String.valueOf(currentRound));
            infModeAttention.setVisibility(View.GONE);
        } else {
            score.setVisibility(View.GONE);
            btnReset.setVisibility(View.GONE);
            scoreVision.setVisibility(View.GONE);
            infModeAttention.setText("Включён бесконечный режим!");
        }


        // сброс счёта
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });


        // выход назад (в меню)
        findViewById(R.id.btnBackGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        wordFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWordButtonClick(view);
            }
        });

        wordSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWordButtonClick(view);
            }
        });

        // создаем копию массива слов и рандомно перемешиваем ее
        remainingWords = new ArrayList<>(Arrays.asList(words));
        long seed = System.nanoTime();
        Random random = new Random(seed);
        for (int i = remainingWords.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String[] temp = remainingWords.get(i);
            remainingWords.set(i, remainingWords.get(j));
            remainingWords.set(j, temp);
        }


        // первичный запуск раунда
        playRound();
    }



    // отыгрыш раунда
    private void playRound() {

        SharedPreferences sharedPreferences = getSharedPreferences(SettingsActivity.SHARED_PREFS, MODE_PRIVATE);
        infinityGame = sharedPreferences.getBoolean(SettingsActivity.INFINITY_GAME, false);


        if (currentRound >= words.length) {
            outputTextView1.setText("");
            outputTextView1.setTextColor(Color.BLACK);
            outputTextView2.setText("");
            if (infinityGame == false) {
                showEndGameDialog();
            } else {
                recreate();
            }
            return;
        }

        // беру данные и удаляю, чтобы в последствии не было повторений в раундах
        // String[] currentWord = remainingWords.remove(0);
        String[] currentWord = remainingWords.remove(0);
        String word = currentWord[0];
        correct = currentWord[1];
        String incorrect = currentWord[2];

        outputWordTextView.setText(word);
        // случайная расстановка слов
        if (Math.random() < 0.5) {
            wordFirstButton.setText(correct);
            wordSecondButton.setText(incorrect);
        } else {
            wordFirstButton.setText(incorrect);
            wordSecondButton.setText(correct);
        }
        // обновление номера раунда
        currentRound++;
    }


    // отыгрыш сценариев w/l
    public void onWordButtonClick(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(SettingsActivity.SHARED_PREFS, MODE_PRIVATE);
        infinityGame = sharedPreferences.getBoolean(SettingsActivity.INFINITY_GAME, false);


        // считывая текст с нажатой кнопки
        String buttonText = ((Button) view).getText().toString();
        // беру правильное слово в переменную
        String correctWord = correct;

        // сравниваю взятое с кнопки слово с правильным словом
        if (buttonText.equals(correctWord)) {
            outputTextView1.setText("Верно!");
            outputTextView1.setTextColor(Color.parseColor("#54DF4A"));
            outputTextView2.setText("Правильное ударение в слове " + correctWord.toLowerCase(Locale.ROOT) + ": " + correctWord + "!");

            // система против накрутки счёта
            if (currentRound < words.length) {
                if (infinityGame == false) {
                    scoreValue++;
                    score.setText(String.valueOf(scoreValue) + " из " + String.valueOf(currentRound));
                    // score.setTextColor(Color.parseColor("#54DF4A"));
                } else {

                }
            }

        } else {
            String word = words[currentRound - 1][0];
            outputTextView1.setText("Неверно!");
            outputTextView2.setText("Правильное ударение в слове " + correctWord.toLowerCase(Locale.ROOT) + ": " + correctWord + "!");
            outputTextView1.setTextColor(Color.parseColor("#DC4343"));
            score.setText(String.valueOf(scoreValue) + " из " + String.valueOf(currentRound));
            if (infinityGame == false) {
                // score.setTextColor(Color.parseColor("#DC4343"));
            }
        }

        // начинаю новый раунд
        playRound();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void showEndGameDialog() {
        endGameDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        endGameDialog.getWindow().setWindowAnimations(R.style.DialogAnimation);


        // Отображение диалогового окна
        endGameDialog.show();

        TextView actualScore = endGameDialog.findViewById(R.id.actualScore);
        if (actualScore != null) {
            if (scoreValue < currentRound) {
                actualScore.setText("Правильно слов: " + String.valueOf(scoreValue) + " из " + String.valueOf(currentRound));
            } else {
                actualScore.setText("Поздравляем! Вы угадали все слова!");
            }
        }

        btnRestart = endGameDialog.findViewById(R.id.btnRestart);
        if (btnRestart != null) {
            btnRestart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    endGameDialog.dismiss();
                    recreate();

                }
            });
        }

        btnMenu = endGameDialog.findViewById(R.id.btnMenu);
        if (btnMenu != null) {
            btnMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    endGameDialog.dismiss();
                    onBackPressed();
                }
            });
        }
    }


}
package io.kchat.newkchat;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView text(String value, float size, int color) {
        TextView v = new TextView(this);
        v.setText(value);
        v.setTextSize(size);
        v.setTextColor(color);
        v.setGravity(Gravity.CENTER_VERTICAL);
        return v;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(18), dp(20), dp(18));
        root.setBackgroundColor(Color.rgb(11, 11, 15));

        TextView title = text("New KChat", 28, Color.WHITE);
        title.setTypeface(null, android.graphics.Typeface.BOLD);
        root.addView(title, new LinearLayout.LayoutParams(-1, dp(52)));

        TextView subtitle = text("Telegram-клиент • версия 0.1.0", 15, Color.LTGRAY);
        root.addView(subtitle, new LinearLayout.LayoutParams(-1, dp(42)));

        TextView status = text(
            "Первая версия готова.\n\nПодключение к Telegram пока не настроено.\nДля настоящего входа нужен собственный Telegram API ID и API hash.",
            16, Color.WHITE);
        status.setPadding(dp(4), dp(20), dp(4), dp(20));
        root.addView(status, new LinearLayout.LayoutParams(-1, 0, 1));

        TextView info = text("New KChat не хранит данные пользователей на сервере проекта.", 13, Color.GRAY);
        root.addView(info, new LinearLayout.LayoutParams(-1, dp(55)));

        setContentView(root);
    }
}

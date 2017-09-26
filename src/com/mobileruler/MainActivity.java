package com.mobileruler;

import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Point point = new Point();
		getWindowManager().getDefaultDisplay().getRealSize(point);
		DisplayMetrics dm = getResources().getDisplayMetrics();
		double Inchesx = point.x / dm.xdpi;
		double Inchesy = point.y / dm.ydpi;
		double cmx = Inchesx * 2.54;
		double cmy = Inchesy * 2.54;
		// double x = Math.pow(Inchesx, 2);
		// double y = Math.pow(Inchesy, 2);
		// double screenInches = Math.sqrt(x + y);
		// logD("Screen inches : " + screenInches);
		// logD("��Ļ��" + cmx + "cm");
		// logD("��Ļ��" + cmy + "cm");
		// logD("5.14 toInt=" + toInt(5.14));
		// logD("5.68 toInt=" + toInt(5.68));

		RulerView ruler = (RulerView) findViewById(R.id.ruler);
		ruler.setSize(toInt(cmx * 10), toInt(cmy * 10))
			.setTextSize(dm.xdpi * 12 / 160)
			.setLineLength((int) (dm.xdpi * 10 / 160))
			.build();

		TextView tv_hint = (TextView) findViewById(R.id.text_hint);
		tv_hint.setText("������Ļ�����ⲿ�֣�" + "\n" + "��(Լ)��" + cmx + "cm" + "\n" + "��(Լ)��" + cmy + "cm");
	}

	/**
	 * ��С����ɫ����ת��������
	 */
	private int toInt(double number) {
		return Integer.parseInt(new java.text.DecimalFormat("0").format(number));
	}

}

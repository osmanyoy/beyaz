package com.training.advanced.java;

public class JavaMain {
	public static void main(final String[] args) {
		IIslem<Double, Double, String> myIslem = (a, b) -> "" + (a + b);

		IOperation<Double> toplama2 = (d, f) -> d + f;

		Double dResult = toplama2.execute(100D,
		                                  50D);

		IOperation<Double> cikarma = (d, f) -> {
			double sonuc = (d * 2) - (f / 3);
			return sonuc;
		};

		Double dResult2 = toplama2.execute(100D,
		                                   50D);

		IToplama toplama = (i1, i2) -> i1 + i2;

		System.out.println("Toplama sonucu : " + (toplama.topla(30,
		                                                        20)));

		System.out.println("Toplama sonucu : " + ((IToplama) (i1, i2) -> i1 + i2).topla(30,
		                                                                                20));
		System.out.println("Çýkarma sonucu : " + (JavaMain.toplamaSonucu((l1, l2) -> l1 - l2,
		                                                                 30,
		                                                                 20)));
		System.out.println("Çarpma sonucu : " + (JavaMain.toplamaSonucu((l1, l2) -> l1 * l2,
		                                                                30,
		                                                                20)));

		IToplama toplama3 = new ToplaImpl();
		System.out.println("Toplama sonucu : " + (toplama3.topla(10,
		                                                         20)));
	}

	public static int toplamaSonucu(final IToplama toplama, final int x, final int y) {
		return toplama.topla(x,
		                     y);
	}
}

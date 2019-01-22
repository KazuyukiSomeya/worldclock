package jp.co.webfrontier.training.worldclock;

import java.time.ZoneOffset;
import java.util.EnumMap;

public enum City {

	/* アルファベット順を保つこと */
	// A
	ADL("ADL", "アデレード"),
	ANC("ANC", "アンカレッジ"),
	AKL("AKL", "オークランド"),
	ATH("ATH", "アテネ"),

	// B
	BER("BER", "ベルリン"),
	BJS("BJS", "北京"),
	BKK("BKK", "バンコク"),
	BUE("BUE", "ブエノスアイレス"),

	// C
	CAI("CAI", "カイロ"),
	CHI("CHI", "シカゴ"),

	// D
	DAC("DAC", "ダッカ"),
	DEL("DEL", "デリー"),
	DEN("DEN", "デンバー"),
	DXB("DXB", "ドバイ"),

	// F
	FEN("FEN", "フェルナンド・デ・ノローニャ諸島"),

	// H
	HKG("HKG", "香港"),
	HNL("HNL", "ホノルル"),

	// J
	JNB("JNB", "ヨハネスブルグ"),

	// K
	KBL("KBL", "カブール"),
	KHI("KHI", "カラチ"),

	// L
	LAX("LAX", "ロサンゼルス"),
	LON("LON", "ロンドン"),

	// M
	MAD("MAD", "マドリード"),
	MAO("MAO", "マナウス"),
	MDY("MDY", "ミッドウェー諸島"),
	MEX("MEX", "メキシコシティ"),

	// N
	NOU("NOU", "ヌーメア"),
	NYC("NYC", "ニューヨーク"),

	// P
	PAR("PAR", "パリ"),

	// R
	RGN("RGN", "ヤンゴン"),
	RIO("RIO", "リオデジャネイロ"),
	ROM("ROM", "ローマ"),
	RUH("RUH", "リヤド"),

	// S
	SEL("SEL", "ソウル"),
	SIN("SIN", "シンガポール"),
	SUV("SUV", "スバ"),
	SYD("SYD", "シドニー"),

	// T
	THR("THR", "テヘラン"),
	TPE("TPE", "台北"),
	TYO("TYO", "東京"),

	// Y
	YMQ("YMQ", "モントリオール"),
	YVR("YVR", "バンクーバー");

	private final String shortName;
	private final String localName;

	City(String shortName, String localName) {
		this.shortName = shortName;
		this.localName = localName;
	}

	public String toString() { return localName; }

	public String getShortName() { return shortName; }

	private static EnumMap<City, ZoneOffset> offsetHoursMap;

	static {
		offsetHoursMap = new EnumMap<City, ZoneOffset>(City.class);
		offsetHoursMap.put(LON, ZoneOffset.of("-00"));
		offsetHoursMap.put(NYC, ZoneOffset.of("-5"));
		offsetHoursMap.put(TYO, ZoneOffset.of("+09"));
		offsetHoursMap.put(PAR, ZoneOffset.of("+01"));
	}

	public static ZoneOffset getOffsetHours(City city) { return offsetHoursMap.get(city); }
}

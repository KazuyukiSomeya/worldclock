package jp.co.webfrontier.training.worldclock;

import java.time.ZoneOffset;
import java.util.EnumMap;

public enum City {

	/* アルファベット順を保つこと */
	// A
	ATH("ATH", "アテネ"),

	// B
	BJS("BJS", "北京"),

	// C
	CAI("CAI", "カイロ"),

	// D
	DXB("DXB", "ドバイ"),

	// F
	FEN("FEN", "フェルナンド・デ・ノローニャ諸島"),

	// H
	HKG("HKG", "香港"),

	// J
	JNB("JNB", "ヨハネスブルグ"),

	// L
	LAX("LAX", "ロサンゼルス"),
	LON("LON", "ロンドン"),

	// M
	MAD("MAD", "マドリード"),

	// N
	NYC("NYC", "ニューヨーク"),

	// P
	PAR("PAR", "パリ"),

	// R
	RIO("RIO", "リオデジャネイロ"),

	// S
	SIN("SIN", "シンガポール"),

	// T
	TYO("TYO", "東京"),

	// Y
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
		offsetHoursMap.put(ATH, ZoneOffset.of("+02"));
		offsetHoursMap.put(BJS, ZoneOffset.of("+08"));
		offsetHoursMap.put(CAI, ZoneOffset.of("+02"));
		offsetHoursMap.put(DXB, ZoneOffset.of("+04"));
		offsetHoursMap.put(FEN, ZoneOffset.of("-02"));
		offsetHoursMap.put(HKG, ZoneOffset.of("+08"));
		offsetHoursMap.put(JNB, ZoneOffset.of("-00"));
		offsetHoursMap.put(LON, ZoneOffset.of("-00"));
		offsetHoursMap.put(MAD, ZoneOffset.of("+01"));
		offsetHoursMap.put(NYC, ZoneOffset.of("-05"));
		offsetHoursMap.put(PAR, ZoneOffset.of("+01"));
		offsetHoursMap.put(RIO, ZoneOffset.of("-03"));
		offsetHoursMap.put(SIN, ZoneOffset.of("+08"));
		offsetHoursMap.put(TYO, ZoneOffset.of("+09"));
		offsetHoursMap.put(YVR, ZoneOffset.of("-08"));
	}

	public static ZoneOffset getOffsetHours(City city) { return offsetHoursMap.get(city); }
}

package jp.co.webfrontier.training.worldclock;

public enum Country {

	/* アルファベット順を保つこと */

	// A
	AE("AE", "アラブ首長国連邦"),
	AF("AF", "アフガニスタン"),
	AR("AR", "アルゼンチン"),
	AU("AU", "オーストラリア"),

	// B
	BR("BR", "ブラジル"),

	// C
	CA("CA", "カナダ"),
	CN("CN", "中華人民共和国"),

	// D
	DE("DE", "ドイツ"),

	// E
	EG("EG", "エジプト"),
	ES("ES", "スペイン"),

	// F
	FJ("FJ", "フィジー諸島共和国"),
	FR("FR", "フランス"),

	// G
	GR("GR", "ギリシャ"),

	// I
	IN("IN", "インド"),
	IR("IR", "イラン"),
	IT("IT", "イタリア"),

	// J
	JP("JP", "日本"),

	// K
	KR("KR", "韓国"),

	// M
	MX("MX", "メキシコ"),

	// N
	NZ("NZ", "ニュージーランド"),

	// S
	SA("SA", "サウジアラビア"),
	SG("SG", "シンガポール"),

	// T
	TH("TH", "タイ"),

	// U
	UK("UK", "イギリス"),
	US("US", "アメリカ合衆国"),

	// Z
	ZA("ZA", "南アフリカ");

	private final String shortName;
	private final String localName;

	Country(String shortName, String localName) {
		this.shortName = shortName;
		this.localName = localName;
	}

	public String toString() { return localName; }

	public String getShortName() { return shortName; }
}

package com.example.spring.oauth.api.values;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransferStatus {
	
	@JsonEnumDefaultValue
	/** U‹àŠz(\10,000)ˆÈã‚Å“ü‹à“ú‘O‚Ìó‘Ô */
	pending,
	/** “ü‹àŠ®—¹Œã‚Ìó‘Ô */
	paid,
	/** ŒûÀŠÔˆá‚¢“™‚Å“ü‹à‚É¸”s‚µ‚½ó‘Ô */
	failed,
	/** PAYJP‚Ì”»’f‚Å‰Á–¿“X—l‘¤‚Ì“ü‹à‚ğT‚¦‚³‚¹‚Ä‚¢‚½‚¾‚¢‚Ä‚¢‚éó‘Ô */
	stop,
	/** ‡Œv‹àŠz‚ª\10,000‚É–‚½‚È‚¢ê‡‚ÍAŸ‰ñ“ü‹à‚ÉŒJ‚è‰z‚µ‚ªs‚í‚ê‚é */
	carried_over,
	/** “ü‹à‚É¸”s‚µAŸ‰ñ“ü‹à‚É‘g‚İ–ß‚µè”—¿‚ª”­¶‚·‚éó‘Ô */
	recombination,

	;

	@JsonValue
	public String getJsonValue() {
		return name();
	}
}

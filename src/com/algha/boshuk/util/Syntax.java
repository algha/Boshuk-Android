package com.algha.boshuk.util;

public final class Syntax {
	private final static class Ligatures {
		private final char iform;
		private final char bform;
		private final char mform;
		private final char eform;
		private final byte btype;

		public Ligatures(char i, char b, char m, char e, byte bt) {
			this.iform = i;
			this.bform = b;
			this.mform = m;
			this.eform = e;
			this.btype = bt;
		}
	}

	private final static Ligatures[] pform = new Ligatures[256];

	private final static char BPAD = '\u0600';
	private final static char BMAX = '\u06ff';

	private final static byte WDBEG = 0;
	private final static byte INBEG = 1;
	private final static byte NOBEG = 2;

	static {
		for (int i = 0; i < pform.length; i++) {
			pform[i] = null;
		}

		pform['\u0627' - BPAD] = new Ligatures('\ufe8d', '\ufe8d', '\ufe8d', '\ufe8e', WDBEG); // A
		pform['\u06d5' - BPAD] = new Ligatures('\ufee9', '\ufee9', '\ufee9', '\ufeea', WDBEG); // E
		pform['\u0628' - BPAD] = new Ligatures('\ufe8f', '\ufe91', '\ufe92', '\ufe90', NOBEG); // B
		pform['\u067e' - BPAD] = new Ligatures('\ufb56', '\ufb58', '\ufb59', '\ufb57', NOBEG); // P
		pform['\u062a' - BPAD] = new Ligatures('\ufe95', '\ufe97', '\ufe98', '\ufe96', NOBEG); // T
		pform['\u062c' - BPAD] = new Ligatures('\ufe9d', '\ufe9f', '\ufea0', '\ufe9e', NOBEG); // J
		pform['\u0686' - BPAD] = new Ligatures('\ufb7a', '\ufb7c', '\ufb7d', '\ufb7b', NOBEG); // CH
		pform['\u062e' - BPAD] = new Ligatures('\ufea5', '\ufea7', '\ufea8', '\ufea6', NOBEG); // X
		pform['\u062f' - BPAD] = new Ligatures('\ufea9', '\ufea9', '\ufeaa', '\ufeaa', INBEG); // D
		pform['\u0631' - BPAD] = new Ligatures('\ufead', '\ufead', '\ufeae', '\ufeae', INBEG); // R
		pform['\u0632' - BPAD] = new Ligatures('\ufeaf', '\ufeaf', '\ufeb0', '\ufeb0', INBEG); // Z
		pform['\u0698' - BPAD] = new Ligatures('\ufb8a', '\ufb8a', '\ufb8b', '\ufb8b', INBEG); // ZH
		pform['\u0633' - BPAD] = new Ligatures('\ufeb1', '\ufeb3', '\ufeb4', '\ufeb2', NOBEG); // S
		pform['\u0634' - BPAD] = new Ligatures('\ufeb5', '\ufeb7', '\ufeb8', '\ufeb6', NOBEG); // SH
		pform['\u063a' - BPAD] = new Ligatures('\ufecd', '\ufecf', '\ufed0', '\ufece', NOBEG); // GH
		pform['\u0641' - BPAD] = new Ligatures('\ufed1', '\ufed3', '\ufed4', '\ufed2', NOBEG); // F
		pform['\u0642' - BPAD] = new Ligatures('\ufed5', '\ufed7', '\ufed8', '\ufed6', NOBEG); // Q
		pform['\u0643' - BPAD] = new Ligatures('\ufed9', '\ufedb', '\ufedc', '\ufeda', NOBEG); // K
		pform['\u06af' - BPAD] = new Ligatures('\ufb92', '\ufb94', '\ufb95', '\ufb93', NOBEG); // G
		pform['\u06ad' - BPAD] = new Ligatures('\ufbd3', '\ufbd5', '\ufbd6', '\ufbd4', NOBEG); // NG
		pform['\u0644' - BPAD] = new Ligatures('\ufedd', '\ufedf', '\ufee0', '\ufede', NOBEG); // L
		pform['\u0645' - BPAD] = new Ligatures('\ufee1', '\ufee3', '\ufee4', '\ufee2', NOBEG); // M
		pform['\u0646' - BPAD] = new Ligatures('\ufee5', '\ufee7', '\ufee8', '\ufee6', NOBEG); // N
		pform['\u06be' - BPAD] = new Ligatures('\ufbaa', '\ufbac', '\ufbad', '\ufbab', NOBEG); // H
		pform['\u0648' - BPAD] = new Ligatures('\ufeed', '\ufeed', '\ufeee', '\ufeee', INBEG); // O
		pform['\u06c7' - BPAD] = new Ligatures('\ufbd7', '\ufbd7', '\ufbd8', '\ufbd8', INBEG); // U
		pform['\u06c6' - BPAD] = new Ligatures('\ufbd9', '\ufbd9', '\ufbda', '\ufbda', INBEG); // Ö
		pform['\u06c8' - BPAD] = new Ligatures('\ufbdb', '\ufbdb', '\ufbdc', '\ufbdc', INBEG); // Ü
		pform['\u06cb' - BPAD] = new Ligatures('\ufbde', '\ufbde', '\ufbdf', '\ufbdf', INBEG); // W
		pform['\u06d0' - BPAD] = new Ligatures('\ufbe4', '\ufbe6', '\ufbe7', '\ufbe5', NOBEG); // É
		pform['\u0649' - BPAD] = new Ligatures('\ufeef', '\ufbe8', '\ufbe9', '\ufef0', NOBEG); // I
		pform['\u064a' - BPAD] = new Ligatures('\ufef1', '\ufef3', '\ufef4', '\ufef2', NOBEG); // Y
		pform['\u0626' - BPAD] = new Ligatures('\ufe8b', '\ufe8b', '\ufe8c', '\ufe8a', NOBEG); // Hemze
	}

	public final static String getUyPFStr(String str) {
		Ligatures lsyn = pform['\u0644' - BPAD];
		Ligatures syn, tsyn;
		String pfstr = "";

		byte bt = WDBEG;
		int n = str.length();
		int i, j = 0;
		char wc;
		char pfwc = '\0';
		char prevwc = '\0';
		char ppfwc = '\0';
		char[] pfwp = new char[n];

		for (i = 0; i < n; i++) {
			wc = str.charAt(i);

			if (BPAD <= wc && wc < BMAX) {
				syn = pform[wc - BPAD];

				if (syn != null) {
					switch (bt) {
					case WDBEG:
						pfwc = syn.iform;
						break;
					case INBEG:
						pfwc = syn.iform;
						break;
					case NOBEG:
						pfwc = syn.eform;
						break;
					default:
						break;
					}

					if (bt != WDBEG) {
						tsyn = pform[prevwc - BPAD];

						if (ppfwc == lsyn.iform && wc == '\u0627') {
							pfwp[j - 1] = '\uFEFB';
							bt = WDBEG;
							continue;
						} else if (ppfwc == lsyn.eform && wc == '\u0627') {
							pfwp[j - 1] = '\uFEFC';
							bt = WDBEG;
							continue;
						}

						if (ppfwc == tsyn.iform) {
							pfwp[j - 1] = tsyn.bform;
						} else if (ppfwc == tsyn.eform) {
							pfwp[j - 1] = tsyn.mform;
						}
					}
					bt = syn.btype;
				} else {
					pfwc = wc;
					bt = WDBEG;
				}
			} else {
				pfwc = wc;
				bt = WDBEG;
			}

			pfwp[j] = pfwc;
			ppfwc = pfwc;
			prevwc = wc;
			j++;
		}

		pfstr = new String(pfwp, 0, j);
		return pfstr;
	}
}
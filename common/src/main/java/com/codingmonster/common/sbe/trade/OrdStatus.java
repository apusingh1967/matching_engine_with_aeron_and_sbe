/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

@SuppressWarnings("all")
public enum OrdStatus {
  New((short) 10),

  PartiallyFilled((short) 11),

  Filled((short) 12),

  Canceled((short) 13),

  Rejected((short) 14),

  /** To be used to represent not present or null. */
  NULL_VAL((short) 255);

  private final short value;

  OrdStatus(final short value) {
    this.value = value;
  }

  /**
   * The raw encoded value in the Java type representation.
   *
   * @return the raw value encoded.
   */
  public short value() {
    return value;
  }

  /**
   * Lookup the enum value representing the value.
   *
   * @param value encoded to be looked up.
   * @return the enum value representing the value.
   */
  public static OrdStatus get(final short value) {
    switch (value) {
      case 10:
        return New;
      case 11:
        return PartiallyFilled;
      case 12:
        return Filled;
      case 13:
        return Canceled;
      case 14:
        return Rejected;
      case 255:
        return NULL_VAL;
    }

    throw new IllegalArgumentException("Unknown value: " + value);
  }
}

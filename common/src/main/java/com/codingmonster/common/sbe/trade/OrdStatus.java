/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

@SuppressWarnings("all")
public enum OrdStatus {
  New((short) 8),

  PartiallyFilled((short) 9),

  Filled((short) 10),

  Canceled((short) 11),

  Rejected((short) 12),

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
      case 8:
        return New;
      case 9:
        return PartiallyFilled;
      case 10:
        return Filled;
      case 11:
        return Canceled;
      case 12:
        return Rejected;
      case 255:
        return NULL_VAL;
    }

    throw new IllegalArgumentException("Unknown value: " + value);
  }
}

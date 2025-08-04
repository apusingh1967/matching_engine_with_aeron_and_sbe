/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe.trade;

@SuppressWarnings("all")
public enum ExecType {
  New((short) 4),

  Fill((short) 5),

  Cancel((short) 6),

  Reject((short) 7),

  /** To be used to represent not present or null. */
  NULL_VAL((short) 255);

  private final short value;

  ExecType(final short value) {
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
  public static ExecType get(final short value) {
    switch (value) {
      case 4:
        return New;
      case 5:
        return Fill;
      case 6:
        return Cancel;
      case 7:
        return Reject;
      case 255:
        return NULL_VAL;
    }

    throw new IllegalArgumentException("Unknown value: " + value);
  }
}

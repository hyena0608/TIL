package chap01;

import chap02.BankStatementCSVParser;
import chap02.BankStatementParser;
import chap02.BankTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

/**
 * 예제 2-15
 * 어서션 구문 사용하기
 */
class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    void shouldParseOneCorrectLine() {
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected
                = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        Assertions.assertEquals(expected.getDate(), result.getDate());
        Assertions.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assertions.assertEquals(expected.getDescription(), result.getDescription());
    }
}
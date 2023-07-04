package com.prgrms.commandLineApplication.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerTest {

  @ParameterizedTest
  @CsvSource(value = {"qkrdmswl1018@naver.com|박은지", "test@gmail.com|사용자2", "email@naver.com|사용자2"}, delimiter = '|')
  @DisplayName("올바른 형식의 이메일과 이름을 작성했을 경우 customer 생성 성공")
  void customer_생성_성공(String email, String name) {
    Customer createdCustomer = Customer.of(email, name);
    assertThat(createdCustomer).isNotNull();
  }

  @ParameterizedTest
  @CsvSource(value = {"qkrdmswl1018naver.com|박은지", "test@gma@$il.com|사용자1", "em!$ail@navercom|사용자2"}, delimiter = '|')
  @DisplayName("이메일 형식이 맞지 않을 경우 예외 발생 성공")
  void customer_email_예외_발생(String email, String name) {
    Assertions.assertThatThrownBy(() -> Customer.of(email, name))
            .isInstanceOf(IllegalArgumentException.class);

  }

}

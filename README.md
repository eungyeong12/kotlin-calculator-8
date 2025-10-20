# ➕ 문자열 덧셈 계산기

## 📝 기능 목록

#### 1. 애플리케이션을 실행하면, '덧셈할 문자열을 입력해 주세요.' 안내 문구를 출력한다.

#### 2. 사용자로부터 입력을 받는다.

#### 3. 커스텀 구분자가 존재하는 경우, 커스텀 구분자를 추출한다.

#### 4. 구분자(기본 구분자, 커스텀 구분자)로 입력값을 분리한다.

#### 5. 분리한 문자열 리스트를 숫자 리스트로 변환한다.

- 문자열을 숫자로 변환할 수 없는 경우, `IllegalArgumentException`을 발생시킨다.
- 변환한 숫자가 음수인 경우, `IllegalArgumentException`을 발생시킨다.

#### 6. 숫자 리스트의 합을 계산한다.

#### 7. 덧셈 결과를 출력한다.

## 💡설계

#### 📁 main

```
calculator
├── config
│   └── ApplicationConfig
│
├── constant
│   └── Constants
│
├── controller
│   └── StringAdditionCalculatorController
│
├── domain
│   ├── calculator
│   │   └── Calculator
│   │
│   ├── delimiter
│   │   ├── CustomDelimiter
│   │   └── Delimiters
│   │
│   └── number
│       └── Numbers
│
├── exception
│   ├── ExceptionMessage
│   └── ValidationException
│
├── service
│   ├── calculator
│   │   └── CalculatorService
│   │
│   ├── delimiter
│   │   └── DelimiterService
│   │
│   └── number
│       └── NumberService
│
├── util
│   └── Util
│
├── view
│   ├── InputView
│   ├── OutputView
│   └── Application.kt
```

#### 📁 test

```
calculator
├── domain
│   ├── calculator
│   │   └── CalculatorTest
│   │
│   ├── delimiter
│   │   ├── CustomDelimiterTest
│   │   └── DelimitersTest
│   │
│   └── number
│       └── NumbersTest
│
├── service
│   ├── calculator
│   │   └── CalculatorServiceTest
│   │
│   ├── delimiter
│   │   └── DelimiterServiceTest
│   │
│   └── number
│       └── NumberServiceTest
│
└── ApplicationTest
```
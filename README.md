# Strange bugs

## ClassCastException with `mockito-kotlin` and `Result.flatMap` extension

Run:

```console
 $ mvn test -Dtest=SomeServiceFlatMapTest
```

## ClassCastException with `mockito-kotlin` and built-in `Result.map`

Run:

```console
 $ mvn test -Dtest=SomeServiceMapTest
```

## `Result.failure(xxx)` results in `isSuccess == true` with `jqwik`

```console
 $ mvn test -Dtest='ForEach*'
```
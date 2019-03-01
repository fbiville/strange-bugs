# Strange bugs

## ClassCastException with `mockito-kotlin` and `Result.flatMap` extension

Run:

```console
 $ mvn test -Dtest=SomeServiceTest
```

## `Result.failure(xxx)` results in `isSuccess == true` with `jqwik`

```console
 $ mvn test -Dtest='ForEach*'
```

**1. how to remove genre from video genre collection when a genre is removed from db?**

Difference between @NotNull, @NotEmpty and @NotBlank.
@NotNull

CharSequence, Collection, Map or Array object cannot be null, however can be empty.

@NotEmpty

The CharSequence, Collection, Map or Array object cannot be null and not empty (size > 0).

@NotBlank

The string is not null and the length is greater than zero.

Here are the examples:

String test = null;
@NotNull: false
@NotEmpty: false
@NotBlank: false

String test = "";
@NotNull: true
@NotEmpty: false
@NotBlank: false

String test = " ";
@NotNull: true
@NotEmpty: true
@NotBlank: false

String name = "Some text";
@NotNull: true
@NotEmpty: true
@NotBlank: true
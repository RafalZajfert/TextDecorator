# TextDecorator
Library to simplify android text styling

## Gradle Dependency (jCenter)

```Gradle
dependencies {
    compile 'software.rsquared:text-decorator:1.0.2'
}
```

[ ![Download](https://api.bintray.com/packages/rsquared/maven/text-decorator/images/download.svg) ](https://bintray.com/rsquared/maven/text-decorator/_latestVersion)

## Sample Usage

```java
Text text = new Text("Test", Text.color(this, R.color.colorPrimary).bold())
        .append(" ")
        .append("clickable", Text.color(Color.RED).underline().click(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked! :D", Toast.LENGTH_SHORT).show();
            }
        }))
        .append("2", Text.superscript().size(0.5f).color(Color.BLUE))
        .withContext(getContext())
        .append(" ")
        .append(R.string.app_name, Text.strikethrough().italic().backgroundColor(this, R.color.colorAccent));

textView.setText(text);
```

\* StringRes can be used only if previously context will be set with method `text.withContext(Context)` or `Text` constructor

#### Available decorators
* Text.backgroundColor
* Text.blur
* Text.bold
* Text.click
* Text.color
* Text.color
* Text.emboss
* Text.italic
* Text.locale
* Text.normal
* Text.scaleX
* Text.size
* Text.strikethrough
* Text.style
* Text.subscript
* Text.superscript
* Text.typeface
* Text.underline
* Text.url

## Developed By

 * Rafal Zajfert - <rz@rsquared.software>

## License

    Copyright 2015 rSquared s.c. R. Orlik, R. Zajfert

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

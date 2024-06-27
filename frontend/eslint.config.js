// @ts-check
const eslint = require("@eslint/js");
const tseslint = require("typescript-eslint");
const angular = require("angular-eslint");
const stylistic = require("@stylistic/eslint-plugin");
const rdlabo = require("@rdlabo/eslint-plugin-rules");

module.exports = tseslint.config(
  {
    files: ["**/*.ts"],
    extends: [
      eslint.configs.recommended,
      ...tseslint.configs.recommended,
      ...tseslint.configs.stylistic,
      ...angular.configs.tsRecommended,
    ],
    processor: angular.processInlineTemplates,
    plugins: {
      "@stylistic": stylistic,
      "@rdlabo": rdlabo
    },
    rules: {
      "@stylistic/comma-spacing": [
        "error",
        {
          "before": false,
          "after": true
        }
      ],
      "no-debugger": "error",
      "no-bitwise": "error",
      "no-console": "warn",
      "no-alert": "warn",
      "@angular-eslint/use-lifecycle-interface": "error",
      "@rdlabo/import-inject-object": "error",
      "@rdlabo/deny-constructor-di": "error",
      "@angular-eslint/directive-selector": [
        "error",
        {
          "type": "attribute",
          "prefix": "app",
          "style": "camelCase"
        }
      ],
      "@angular-eslint/component-selector": [
        "error",
        {
          "type": "element",
          "prefix": "app",
          "style": "kebab-case"
        }
      ],
      "@typescript-eslint/no-extraneous-class": [
        "error",
        {
          "allowEmpty": true
        }
      ],
      "@angular-eslint/no-empty-lifecycle-method": [
        "error"
      ],
      "semi": [
        "error",
        "always"
      ],
    },
  },
  {
    files: ["**/*.html"],
    extends: [
      ...angular.configs.templateRecommended,
      ...angular.configs.templateAccessibility,
    ],
    rules: {},
  }
);

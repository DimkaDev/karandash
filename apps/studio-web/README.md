# SiteForge frontend scaffold

Node.js 24.22.1 and npm 11.19.1. `.nvmrc`, `engines`, exact direct
versions and `package-lock.json` define the development baseline.
Use `nvm install` and `nvm use` inside this directory if nvm is installed;
otherwise configure the same Node version through your preferred manager.

From the repository root:

```sh
npm --prefix apps/studio-web ci
npm --prefix apps/studio-web run build
npm --prefix apps/studio-web test -- --watch=false
npm --prefix apps/studio-web run lint
npm --prefix apps/studio-web start
```

Development listens on `http://127.0.0.1:4200`. The application currently
renders a development-scaffold notice, with no product controls, authentication
or API integration. Visual direction and product screens are later tasks.
The router is configured with no product routes.

TypeScript strict mode and Angular strict templates are enabled. Unit tests
use Angular's Vitest builder; ESLint covers TypeScript and inline templates.
Production output is written under `dist/`. Do not commit `node_modules/`,
`.angular/` or `dist/`.

`@angular/build` currently pins Vite 8.3.0, affected by npm advisories.
A scoped npm override selects its patched Vite 8.3.3. Revisit the override
when Angular's builder adopts a patched release; verify build, tests and audit
before removing it. The override does not change unrelated Vite instances.

Browser end-to-end tooling will be added in P0-09; no `test:e2e` success is
claimed in this increment. No backend connection is needed to run the scaffold.

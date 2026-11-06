# SiteForge: Phase 0 задачи

Дата: 2026-10-26. Статус: план для проверки. Все implementation tasks открыты.
Основание и архитектурные решения: [plan.md](plan.md). Ссылки spec.md: относительные к корню проекта.

## Команды и правила

- `B` ниже раскрывается в `services/control-plane/mvnw -f services/control-plane/pom.xml`.
- `F` ниже раскрывается в `npm --prefix apps/studio-web`.
- Полный backend build/test: `B verify`; frontend: `F ci`, `F test -- --watch=false`, `F run lint`, `F run build`; browser: `F run test:e2e`.
- Это планируемые command contracts. До scaffold никакие application tests не считаются выполненными. Имена test classes ниже являются обязательными будущими regression suites, не существующими файлами.
- Generated boilerplate в bootstrap P0-02/03 создаётся минимальным официальным scaffold; перечислены до пяти управляемых entrypoints. Если ручная реализация задачи требует более пяти файлов, разделить её перед началом и сохранить acceptance criteria; не сокращать тесты ради размера.
- Порядок задан таблицей и dependencies. После каждого checkpoint показать человеку работающий срез. Не реализовывать Phase 1 до G1.
- Contract/API schema изменения фиксируются до endpoint implementation. Не открывать private origin/добавлять scripts в generated content ради ускорения.
- Mock провайдеры и synthetic data по умолчанию. Настоящие email/AI вызовы только в явно настроенном тестовом окружении; отправка реальным prospects всегда требует действия основателя.

## P0-01: Визуальный бриф

- [ ] Задача завершена

**Результат:** Собрать ответы основателя о характере SiteForge и garden-care template; записать его решения, а не выдуманный бренд.

**Критерии готовности:**
- [ ] Определены audience, tone, palette и typography для public page, inbox и template.
- [ ] Записаны Design Read и ENERGY/RHYTHM/MOTION; нет неразрешённых assets.
- [ ] Основатель подтвердил brief до UI implementation.

**Проверка:** Ручной review DESIGN.md.

**Зависимости:** Нет.

**Вероятные файлы:**
- `DESIGN.md`

**Размер:** S; 1 управляемых файлов; при превышении разбить до реализации.

## P0-02: Backend skeleton

- [x] Задача завершена

**Результат:** Создать Quarkus backend с Maven wrapper и reproducible version pins.

**Критерии готовности:**
- [x] Закреплены совместимые Java/Quarkus версии.
- [x] Maven wrapper выполняет verify на чистом окружении.
- [x] Есть local/test profiles без секретов.

**Проверка:** B verify.

**Зависимости:** Нет.

**Вероятные файлы:**
- `services/control-plane/pom.xml`
- `services/control-plane/mvnw`
- `services/control-plane/.mvn/wrapper/maven-wrapper.properties`
- `services/control-plane/src/main/resources/application.properties`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

**Выполнено 2026-10-26:** Quarkus 3.40.1.1, Java target 21 (проверено на Corretto 21.0.13), Maven wrapper 3.9.16 с checksum. `verify`: BootstrapTest + BootstrapIT, 2 теста, 0 failures/errors/skips; packaged JAR запускается. Evidence: `docs/verification/p0-02.md`. Коммит отсутствует: папка не является Git repository.

## P0-03: Frontend skeleton

- [x] Задача завершена

**Результат:** Создать минимальный Angular workspace; закрепить Node/npm и frontend scripts.

**Критерии готовности:**
- [x] Strict TypeScript, versions и lockfile зафиксированы.
- [x] Install/build/test/lint scripts исполнимы.
- [x] Генератор создаёт только минимальный app; исключён ненужный demo UI.

**Проверка:** F ci; F run build; F test -- --watch=false; F run lint.

**Зависимости:** Нет.

**Вероятные файлы:**
- `apps/studio-web/package.json`
- `apps/studio-web/package-lock.json`
- `apps/studio-web/angular.json`
- `apps/studio-web/tsconfig.json`
- `apps/studio-web/.nvmrc`

**Размер:** M; 5 управляемых файлов; при превышении разбить до реализации.

**Выполнено 2026-10-26:** Angular 22.2.3, CLI/build 22.2.4, Node 24.22.1 и npm 11.19.1; exact dependencies и lockfile. `npm ci`, production build, 2 unit tests и lint прошли; audit: 0 vulnerabilities после scoped Vite override 8.3.3. Browser scaffold отображается, warn/error console пуст. Evidence: `docs/verification/p0-03.md`. P0-01 остаётся открыт; Git commit отсутствует.

### Checkpoint после P0-03

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-04: PostgreSQL и health

- [ ] Задача завершена

**Результат:** Добавить local infrastructure, начальную миграцию и readiness.

**Критерии готовности:**
- [ ] PostgreSQL доступен в local/test.
- [ ] Миграция применяется на пустой базе и повторный старт безопасен.
- [ ] Health отражает недоступность БД.

**Проверка:** B -Dtest=DatabaseHealthTest test.

**Зависимости:** P0-02.

**Вероятные файлы:**
- `infra/compose.yaml`
- `services/control-plane/src/main/resources/db/migration/V001__foundation.sql`
- `services/control-plane/src/test/java/siteforge/DatabaseHealthTest.java`

**Размер:** M; 3 управляемых файлов; при превышении разбить до реализации.

## P0-05: CI baseline

- [ ] Задача завершена

**Результат:** Сделать backend/frontend проверки обязательными и задокументировать запуск.

**Критерии готовности:**
- [ ] CI выполняет build/tests/lint и secret/dependency scanning.
- [ ] Secrets и generated build outputs исключены.
- [ ] README команд совпадает с исполнимыми scripts.

**Проверка:** Проверка CI и clean-checkout smoke run.

**Зависимости:** P0-02, P0-03, P0-04.

**Вероятные файлы:**
- `.github/workflows/ci.yml`
- `docs/development.md`
- `.gitignore`

**Размер:** M; 3 управляемых файлов; при превышении разбить до реализации.

## P0-06: Site contracts

- [ ] Задача завершена

**Результат:** Определить blueprint/site/pack contracts до generation API.

**Критерии готовности:**
- [ ] Версии и allowlisted sections/actions определены.
- [ ] Unknown properties и executable content отклоняются.
- [ ] Valid и negative fixtures покрывают обязательные поля.

**Проверка:** B -Dtest=SchemaContractTest test.

**Зависимости:** P0-04.

**Вероятные файлы:**
- `packages/site-schema/blueprint.schema.json`
- `packages/site-schema/site.schema.json`
- `packages/site-schema/pack.schema.json`
- `packages/site-schema/fixtures/valid-site.json`
- `services/control-plane/src/test/java/siteforge/SchemaContractTest.java`

**Размер:** M; 5 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-06

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-07: Garden-care pack

- [ ] Задача завершена

**Результат:** Подготовить deep pack garden care и base pack septic из подтверждённых правил.

**Критерии готовности:**
- [ ] Оба pack проходят schema.
- [ ] Нет fabricated prices/reviews/certifications.
- [ ] FR/EN defaults и запрещённые утверждения заданы.

**Проверка:** B -Dtest=PackContractTest test.

**Зависимости:** P0-06.

**Вероятные файлы:**
- `packs/garden-care.json`
- `packs/septic-servicing.json`
- `services/control-plane/src/test/java/siteforge/PackContractTest.java`

**Размер:** M; 3 управляемых файлов; при превышении разбить до реализации.

## P0-08: Renderer landing template

- [ ] Задача завершена

**Результат:** Создать Qute static renderer и template на valid fixture.

**Критерии готовности:**
- [ ] HTML/CSS детерминированны и текст экранируется.
- [ ] FR/EN lang и типографика корректны.
- [ ] Demo mock controls обозначены и не принимают реальные обращения.

**Проверка:** B -Dtest=RendererTest test; ручная проверка fixture HTML.

**Зависимости:** P0-01, P0-06, P0-07.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/rendering/SiteRenderer.java`
- `services/control-plane/src/main/resources/templates/site.html`
- `services/control-plane/src/main/resources/templates/site.css`
- `services/control-plane/src/test/java/siteforge/RendererTest.java`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

## P0-09: Renderer browser checks

- [ ] Задача завершена

**Результат:** Проверить template на desktop/mobile, клавиатурой и axe.

**Критерии готовности:**
- [ ] Нет horizontal overflow на 360/768/1440 px.
- [ ] Автоматический accessibility score ≥90; нет serious/critical findings.
- [ ] Ручные focus, keyboard, labels, contrast checks записаны.

**Проверка:** F run test:e2e -- renderer.spec.ts.

**Зависимости:** P0-08, P0-03.

**Вероятные файлы:**
- `apps/studio-web/e2e/renderer.spec.ts`
- `apps/studio-web/playwright.config.ts`
- `apps/studio-web/package.json`
- `apps/studio-web/package-lock.json`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-09

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-10: Magic-link issuance

- [ ] Задача завершена

**Результат:** Создать allowlisted выдачу magic link и локальный mail adapter.

**Критерии готовности:**
- [ ] Ответ не раскрывает allowlist.
- [ ] Только hash токена хранится; TTL 15 минут; rate limits.
- [ ] Local mail sink получает письмо; raw token не логируется.

**Проверка:** B -Dtest=MagicLinkIssueTest test.

**Зависимости:** P0-04, P0-05.

**Вероятные файлы:**
- `docs/openapi.yaml`
- `services/control-plane/src/main/java/siteforge/auth/MagicLinkResource.java`
- `services/control-plane/src/main/java/siteforge/notifications/MailAdapter.java`
- `services/control-plane/src/main/resources/db/migration/V002__auth.sql`
- `services/control-plane/src/test/java/siteforge/MagicLinkIssueTest.java`

**Размер:** M; 5 управляемых файлов; при превышении разбить до реализации.

## P0-11: Session и защита Studio

- [ ] Задача завершена

**Результат:** Погашать link только POST и защищать Studio endpoints.

**Критерии готовности:**
- [ ] Токен одноразовый; email-scanner GET его не расходует.
- [ ] Session secure HttpOnly SameSite, idle 30 минут, absolute 12 часов; logout отзывает.
- [ ] Без session и CSRF изменения запрещены.

**Проверка:** B -Dtest=SessionSecurityTest test.

**Зависимости:** P0-10.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/auth/SessionResource.java`
- `services/control-plane/src/main/java/siteforge/auth/StudioSecurity.java`
- `services/control-plane/src/test/java/siteforge/SessionSecurityTest.java`
- `docs/openapi.yaml`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

## P0-12: Founder sign-in UI

- [ ] Задача завершена

**Результат:** Добавить sign-in и protected app shell без полноценного Studio.

**Критерии готовности:**
- [ ] Magic link открывает разрешённую панель.
- [ ] Есть loading/error/expired states.
- [ ] Logout и denied routes работают в браузере.

**Проверка:** F run test:e2e -- auth.spec.ts.

**Зависимости:** P0-01, P0-03, P0-11.

**Вероятные файлы:**
- `apps/studio-web/src/app/auth.component.ts`
- `apps/studio-web/src/app/app.routes.ts`
- `apps/studio-web/src/app/studio-shell.component.ts`
- `apps/studio-web/e2e/auth.spec.ts`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-12

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-13: Ручной brief в панели

- [ ] Задача завершена

**Результат:** Реализовать ручное создание prospect/project с owner-provided facts.

**Критерии готовности:**
- [ ] Brief сохраняет source и facts; не импортирует public listings.
- [ ] Project доступен только основателю.
- [ ] Form/API validation limits совпадают.

**Проверка:** B -Dtest=ProjectBriefTest test; F run build.

**Зависимости:** P0-06, P0-12.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/projects/ProjectResource.java`
- `services/control-plane/src/main/resources/db/migration/V003__projects.sql`
- `apps/studio-web/src/app/brief.component.ts`
- `services/control-plane/src/test/java/siteforge/ProjectBriefTest.java`
- `docs/openapi.yaml`

**Размер:** M; 5 управляемых файлов; при превышении разбить до реализации.

## P0-14: Mock generation job

- [ ] Задача завершена

**Результат:** Добавить persisted async job и mock provider; результатом является validated revision.

**Критерии готовности:**
- [ ] Idempotency исключает duplicate active jobs.
- [ ] Row locks и lease recovery переживают рестарт без потери job.
- [ ] Mock выдаёт schema-valid revision; failure не портит предыдущую.

**Проверка:** B -Dtest=GenerationJobTest test.

**Зависимости:** P0-07, P0-13.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/generation/GenerationService.java`
- `services/control-plane/src/main/java/siteforge/generation/GenerationProvider.java`
- `services/control-plane/src/main/resources/db/migration/V004__jobs.sql`
- `services/control-plane/src/test/java/siteforge/GenerationJobTest.java`
- `docs/openapi.yaml`

**Размер:** M; 5 управляемых файлов; при превышении разбить до реализации.

## P0-15: AI budget accounting

- [ ] Задача завершена

**Результат:** Реализовать usage ledger и атомарное резервирование до provider dispatch.

**Критерии готовности:**
- [ ] Сумма reserved/actual всех job types учитывается в месячном cap.
- [ ] Concurrent jobs не расходуют один остаток; uncertain charges остаются reserved.
- [ ] UTC reset и 80% alert проверены с test clock.

**Проверка:** B -Dtest=BudgetConcurrencyTest test.

**Зависимости:** P0-14.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/usage/BudgetService.java`
- `services/control-plane/src/main/resources/db/migration/V005__usage.sql`
- `services/control-plane/src/test/java/siteforge/BudgetConcurrencyTest.java`

**Размер:** M; 3 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-15

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-16: Grounding validator

- [ ] Задача завершена

**Результат:** Проверять generated facts и ограничить repair attempts.

**Критерии готовности:**
- [ ] Номера/цены/контакты/claims сопоставляются с confirmed facts.
- [ ] Максимум 2 repair calls, каждый проходит budget gate.
- [ ] Неисправимое становится marked missing; previous valid revision сохраняется.

**Проверка:** B -Dtest=GroundingTest test.

**Зависимости:** P0-06, P0-14.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/generation/GroundingValidator.java`
- `services/control-plane/src/test/java/siteforge/GroundingTest.java`
- `packages/site-schema/fixtures/grounding-cases.json`

**Размер:** M; 3 управляемых файлов; при превышении разбить до реализации.

## P0-17: Настоящий AI adapter и eval

- [ ] Задача завершена

**Результат:** Подключить Anthropic adapter за общим contract, оценить модели на fixtures.

**Критерии готовности:**
- [ ] Зафиксированы exact model IDs, prompt version, pricing inputs и timeout.
- [ ] Mock contract tests покрывают schema error, timeout, refusal и quota failure.
- [ ] FR/EN eval из section 11.5 записывает validity, grounding, cost и latency; language reviewer подтверждает текст.

**Проверка:** B -Dtest=ProviderContractTest test; отдельный opt-in paid eval.

**Зависимости:** P0-15, P0-16.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/generation/AnthropicProvider.java`
- `services/control-plane/src/main/resources/prompts/generate.txt`
- `services/control-plane/src/test/java/siteforge/ProviderContractTest.java`
- `docs/model-evaluation.md`
- `packages/site-schema/fixtures/eval-briefs.json`

**Размер:** M; 5 управляемых файлов; при превышении разбить до реализации.

## P0-18: Generate → preview в панели

- [ ] Задача завершена

**Результат:** Соединить brief, job status и isolated preview.

**Критерии готовности:**
- [ ] Кнопка запускает job и polling без duplicate dispatch.
- [ ] Loading/failure/retry видны; budget reset time правдив.
- [ ] Основатель видит generated demo в isolated iframe.

**Проверка:** F run test:e2e -- generation.spec.ts; B verify.

**Зависимости:** P0-08, P0-12, P0-13, P0-14, P0-17.

**Вероятные файлы:**
- `apps/studio-web/src/app/generation.component.ts`
- `services/control-plane/src/main/java/siteforge/rendering/PreviewResource.java`
- `apps/studio-web/e2e/generation.spec.ts`
- `docs/openapi.yaml`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-18

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-19: Публичный request contract

- [ ] Задача завершена

**Результат:** Добавить concierge request persistence и consent evidence.

**Критерии готовности:**
- [ ] Поля/limits соответствуют section 21.3; source=ad_request.
- [ ] Consent version/time и UTM сохраняются; receipt не раскрывает brief.
- [ ] Same idempotency key/body не дублирует; conflicting body даёт 409.

**Проверка:** B -Dtest=RequestContractTest test.

**Зависимости:** P0-04, P0-11.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/requests/RequestResource.java`
- `services/control-plane/src/main/resources/db/migration/V006__requests.sql`
- `services/control-plane/src/test/java/siteforge/RequestContractTest.java`
- `docs/openapi.yaml`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

## P0-20: Anti-abuse для request intake

- [ ] Задача завершена

**Результат:** Поставить bot validation и rate limits до записи данных.

**Критерии готовности:**
- [ ] Honeypot, missing consent и failed challenge не создают request/prospect.
- [ ] Per-IP/email limits ограничивают burst; raw IP не сохраняется.
- [ ] IP pseudonym salt и retention документированы; challenge outage fail-closed.

**Проверка:** B -Dtest=RequestAbuseTest test.

**Зависимости:** P0-19.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/requests/RequestAbuseGuard.java`
- `services/control-plane/src/test/java/siteforge/RequestAbuseTest.java`
- `services/control-plane/src/main/resources/application.properties`

**Размер:** M; 3 управляемых файлов; при превышении разбить до реализации.

## P0-21: Request landing FR/EN

- [ ] Задача завершена

**Результат:** Собрать public request page двух ниш с общей form logic.

**Критерии готовности:**
- [ ] FR default/EN switch, niche defaults и UTM сохраняются.
- [ ] Форма показывает validation/loading/success/retry states без потери введённого текста.
- [ ] Copy не содержит unvalidated guarantees, fake claims или identity placeholders на production.

**Проверка:** F run test:e2e -- request.spec.ts.

**Зависимости:** P0-01, P0-03, P0-19, P0-20.

**Вероятные файлы:**
- `apps/studio-web/src/app/request-page.component.ts`
- `apps/studio-web/src/app/request-page.css`
- `apps/studio-web/src/app/request-copy.ts`
- `apps/studio-web/e2e/request.spec.ts`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-21

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-22: Protected inbox API

- [ ] Задача завершена

**Результат:** Добавить список/детали запросов и связывание с project.

**Критерии готовности:**
- [ ] Public access запрещён; pagination и status filter работают.
- [ ] Fulfil создаёт один project из owner-provided request.
- [ ] Повторный fulfil возвращает текущий project, не дубликат.

**Проверка:** B -Dtest=InboxSecurityTest test.

**Зависимости:** P0-13, P0-19.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/requests/InboxResource.java`
- `services/control-plane/src/test/java/siteforge/InboxSecurityTest.java`
- `docs/openapi.yaml`

**Размер:** M; 3 управляемых файлов; при превышении разбить до реализации.

## P0-23: Inbox UI

- [ ] Задача завершена

**Результат:** Показать requests и переиспользовать generation flow.

**Критерии готовности:**
- [ ] Есть empty/loading/error, status filter и request detail.
- [ ] Генерация из заявки использует тот же path, что ручной brief.
- [ ] Founder preview не считается external view.

**Проверка:** F run test:e2e -- inbox.spec.ts.

**Зависимости:** P0-12, P0-18, P0-22.

**Вероятные файлы:**
- `apps/studio-web/src/app/inbox.component.ts`
- `apps/studio-web/src/app/request-detail.component.ts`
- `apps/studio-web/e2e/inbox.spec.ts`

**Размер:** M; 3 управляемых файлов; при превышении разбить до реализации.

## P0-24: Уведомление о новой заявке

- [ ] Задача завершена

**Результат:** Создать retryable founder notification без утечки brief в logs.

**Критерии готовности:**
- [ ] Valid request создаёт одно notification job.
- [ ] Failure виден в inbox; duplicate callback не дублирует email.
- [ ] Письмо ведёт в protected inbox; public receipt не даёт доступа.

**Проверка:** B -Dtest=RequestNotificationTest test.

**Зависимости:** P0-10, P0-14, P0-19.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/notifications/RequestNotification.java`
- `services/control-plane/src/test/java/siteforge/RequestNotificationTest.java`
- `services/control-plane/src/main/resources/templates/request-email.txt`

**Размер:** M; 3 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-24

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-25: Private demo links

- [ ] Задача завершена

**Результат:** Выдавать и отзывать demo capability, проверять HTML/assets.

**Критерии готовности:**
- [ ] ≥128-bit random token; hash storage; expiry 14 дней.
- [ ] Expired/revoked HTML/assets дают 410; неизвестный token 404; origin закрыт.
- [ ] Noindex/no-store/no-referrer и token log redaction проверены.

**Проверка:** B -Dtest=DemoAccessTest test.

**Зависимости:** P0-08, P0-11, P0-18.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/sharing/DemoResource.java`
- `services/control-plane/src/main/resources/db/migration/V007__demo_links.sql`
- `services/control-plane/src/test/java/siteforge/DemoAccessTest.java`
- `docs/openapi.yaml`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

## P0-26: Подготовка и отправка demo email

- [ ] Задача завершена

**Результат:** Добавить server-side preview и idempotent delivery job.

**Критерии готовности:**
- [ ] Отправка только подтверждённой revision по explicit action.
- [ ] Withdrawal/expiry проверяются перед dispatch; timestamp и footer корректны.
- [ ] Unknown provider result требует reconciliation; DELIVERED только после accepted.

**Проверка:** B -Dtest=DemoDeliveryTest test.

**Зависимости:** P0-15, P0-24, P0-25.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/notifications/DemoDeliveryResource.java`
- `services/control-plane/src/main/resources/templates/demo-email.txt`
- `services/control-plane/src/main/resources/db/migration/V008__delivery.sql`
- `services/control-plane/src/test/java/siteforge/DemoDeliveryTest.java`
- `docs/openapi.yaml`

**Размер:** M; 5 управляемых файлов; при превышении разбить до реализации.

## P0-27: Review-and-send UI

- [ ] Задача завершена

**Результат:** Дать основателю последний просмотр сайта и письма перед отправкой.

**Критерии готовности:**
- [ ] Site и email preview доступны до кнопки Send.
- [ ] Двойной клик и reload не отправляют второй email.
- [ ] Failure/uncertain state объясняет следующий безопасный шаг.

**Проверка:** F run test:e2e -- delivery.spec.ts.

**Зависимости:** P0-23, P0-26.

**Вероятные файлы:**
- `apps/studio-web/src/app/delivery.component.ts`
- `apps/studio-web/e2e/delivery.spec.ts`

**Размер:** S; 2 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-27

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-28: Withdrawal и suppression

- [ ] Задача завершена

**Результат:** Добавить manual STOP processing в inbox и запрет queued sends.

**Критерии готовности:**
- [ ] Founder может немедленно отозвать consent и зафиксировать STOP.
- [ ] Queued notifications и новые sends блокируются.
- [ ] Тест withdrawal-vs-send гонки; уже принятый provider email не заявляется отозванным.

**Проверка:** B -Dtest=WithdrawalTest test.

**Зависимости:** P0-22, P0-26.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/requests/WithdrawalService.java`
- `services/control-plane/src/test/java/siteforge/WithdrawalTest.java`
- `apps/studio-web/src/app/request-detail.component.ts`
- `docs/runbooks/withdrawal.md`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

## P0-29: Retention cleanup

- [ ] Задача завершена

**Результат:** Удалять requests, related content и восстановленные удалённые данные.

**Критерии готовности:**
- [ ] 30/60-day request expiry и 7-day withdrawal deletion проверены clock tests.
- [ ] Related demos/assets/cache/queued payloads очищаются; logs без content.
- [ ] Deletion ledger применяется после backup restore до reopening.

**Проверка:** B -Dtest=RetentionTest test.

**Зависимости:** P0-25, P0-28.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/operations/RetentionJob.java`
- `services/control-plane/src/main/resources/db/migration/V009__deletions.sql`
- `services/control-plane/src/test/java/siteforge/RetentionTest.java`
- `docs/runbooks/retention.md`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

## P0-30: G1 evidence и view counts

- [ ] Задача завершена

**Результат:** Фиксировать approximate views, demo sent и substantive replies.

**Критерии готовности:**
- [ ] Из fetch не делается вывод об unique people; preview/bots исключены.
- [ ] Founder отмечает call/meeting/price question с датой и request reference.
- [ ] Отчёт G1 показывает 10 requests/3 responses/6-week window без авто-перехода в Phase 1.

**Проверка:** B -Dtest=GateReportTest test; F run build.

**Зависимости:** P0-25, P0-27.

**Вероятные файлы:**
- `services/control-plane/src/main/java/siteforge/pipeline/GateReportResource.java`
- `services/control-plane/src/test/java/siteforge/GateReportTest.java`
- `apps/studio-web/src/app/gate-report.component.ts`
- `docs/openapi.yaml`

**Размер:** M; 4 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-30

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.

## P0-31: Deployment и provider configuration

- [ ] Задача завершена

**Результат:** Подготовить EU VPS compose/Caddy, production adapters и secret configuration.

**Критерии готовности:**
- [ ] Domains/operator identity/email/storage/bot providers подтверждены основателем; цены укладываются в cap.
- [ ] TLS, private origin, session isolation, email authentication и log redaction проверены.
- [ ] Backup encrypted/off-host; restore на disposable environment проверен; object storage private.

**Проверка:** Deployment smoke checks + restore rehearsal; без покупки ресурсов в задаче планирования.

**Зависимости:** P0-05, P0-20, P0-24, P0-25, P0-29.

**Вероятные файлы:**
- `infra/compose.production.yaml`
- `infra/Caddyfile`
- `docs/runbooks/deployment.md`
- `docs/processors.md`
- `docs/runbooks/backup-restore.md`

**Размер:** M; 5 управляемых файлов; при превышении разбить до реализации.

## P0-32: Полный production-like flow

- [ ] Задача завершена

**Результат:** Проверить всю цепочку и failure modes на staging с synthetic inputs.

**Критерии готовности:**
- [ ] Request→inbox→generation→review→email→demo работает FR/EN.
- [ ] Auth, concurrency budget, outage, expiry/revoke, retention и duplicate-send tests проходят.
- [ ] Browser accessibility/keyboard/mobile и prompt-injection/grounding regression evidence записаны.

**Проверка:** B verify; F test -- --watch=false; F run lint; F run build; F run test:e2e.

**Зависимости:** P0-21, P0-27, P0-28, P0-29, P0-30, P0-31.

**Вероятные файлы:**
- `apps/studio-web/e2e/concierge.spec.ts`
- `docs/verification/phase0.md`

**Размер:** S; 2 управляемых файлов; при превышении разбить до реализации.

## P0-33: G0 launch preflight

- [ ] Задача завершена

**Результат:** Проверить readiness перед данными реальных людей и рекламой.

**Критерии готовности:**
- [ ] Нет placeholder identity; notices/consent/processor records и employer check подтверждены.
- [ ] €300 experiment pool, €30 AI/month и €500 total/month настроены; stop rules документированы.
- [ ] Основатель разрешил запуск; G1 clocks и ручное ведение replies настроены.

**Проверка:** Ручной founder sign-off и повторный end-to-end smoke до рекламы.

**Зависимости:** P0-32.

**Вероятные файлы:**
- `docs/checklists/g0-launch.md`
- `docs/verification/phase0.md`

**Размер:** S; 2 управляемых файлов; при превышении разбить до реализации.

### Checkpoint после P0-33

- [ ] Focused tests и build затронутого среза проходят.
- [ ] Результат показан основателю; ограничения и evidence записаны.
- [ ] Следующие зависимости и launch blockers проверены; не объявлены выполненными заранее.


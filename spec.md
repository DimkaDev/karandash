# SiteForge: MVP Specification v1.2

**Demo-first AI website studio for small businesses**

Status: v1.2, refined draft awaiting founder review · Date: 2026-10-25 · Replaces: v1.1. Recorded founder decisions remain in force; proposed clarifications and outstanding launch prerequisites are distinguished below · Audience: founder and AI coding agents (Codex) · `SiteForge` is a placeholder name.

### v1.2 review changes

- Move secure demo sharing and minimal operator access into Phase 0 so the concierge journey can run before Gate G1.
- Align acquisition, retention, budget recovery, caching and hosting requirements with the recorded decisions.
- Replace unsupported advertising promises with descriptions of the actual offer.
- Add implementation commands, verification expectations and unresolved decisions. This revision authorizes no implementation; review it before planning the next phase.

## 1. What changed from v0.1

| Topic | v0.1 | v1.0 | Why |
| --- | --- | --- | --- |
| Business model | Self-serve SaaS subscription | Managed sites plus a support subscription; the founder edits | Founder decision D1. Assumption to validate: owners want a finished site more than a tool |
| Go-to-market | Sign up, trial, publish | Demo-first: a prospect sees a generated site of their own business before paying; a public sandbox acts as lead magnet | Founder decision D2 |
| Customer access | Customer dashboard and editor | None in MVP; customers receive a site, lead emails and support | Removes the largest build items: customer auth, editor, entitlements |
| Scope | About 66 P0 requirements, five verticals | One deep niche pack plus shallow category packs; landing page and lead capture | Fits 20–30 h/week |
| Billing | Provider integration, webhooks, entitlements | Manual: payment link plus a status record | No legal entity yet; automate after Gates G2 and G-L |
| Custom domains | Automated verification and TLS | Operator runbook | Highest operational cost, lowest early value |
| Validation | Milestone 0 prose | Explicit gates with kill criteria (section 4) | Revenue-first working mode |
| Needs detection | Not specified | Blueprint model with landing, catalogue, booking, shop and admin signals (section 6) | Founder requirement |

**Kept from v0.1:** JSON instead of generated code, allowlisted components, static published sites, AI output treated as untrusted input, tenant-scoped data, versioned prompts and schemas, idempotent jobs, Definition of Done.

## 2. Product summary

SiteForge generates a credible website for a specific small business from a short description, ideally within about a minute (target to validate), and uses that site to start a sales conversation. If the business wants it, the founder polishes it, publishes it and sells a monthly support plan.

Three surfaces:

1. **Demo Sandbox (public).** A visitor picks a business area, adds name, city and a few sentences, and receives a generated demo site. Demos are unlisted, watermarked and expiring, and end with a call to action that captures the visitor as a lead.
2. **Operator Studio (founder only).** Creates projects for prospects, runs generation, edits sections manually or with AI, shares demo links, tracks the sales pipeline, publishes sites and handles lead and change requests.
3. **Published Sites (public, static).** Pre-rendered HTML and CSS with contact actions and an enquiry form. No AI call at request time.

### Principles

1. Demo before pitch.
2. AI produces structured data, never executable code.
3. Honest by construction: no invented facts, reviews, certifications, prices or addresses.
4. Managed first: build only what lets the founder deliver and support sites faster.
5. Static output and minimal moving parts.
6. Measure what decides viability: funnel, AI cost, founder minutes per site.

## 3. Decision log

| ID | Decision | Implication |
| --- | --- | --- |
| D1 | Sell managed sites with a support subscription, not self-serve | No customer login or editor in MVP |
| D2 | Demo-first outreach plus a public sandbox generator | Generation must be fast, cheap and abuse-resistant |
| D3 | Capacity 20–30 founder hours per week with AI coding agents; total budget at most €500/month covering infrastructure, AI and ads (confirmed) | Modular monolith, one small deployment |
| D4 | Founder has no sales experience yet and will build it | Studio includes a pipeline log, demo-view tracking and outcome capture so learning is data-driven |
| D5 | No revenue target; the aim is to build an own business and learn to sell | Success is defined by gates (section 4), not income |
| D6 | No legal entity yet; currently exploratory | No invoicing before Gate G-L |
| D7 | Java + Quarkus, Angular, PostgreSQL | Carried over from v0.1 |
| D8 | Languages: English and French (confirmed). Niche: garden care (deep pack) and septic servicing (second ad-test niche), decided 2026-10-25 | **Resolved: OD-1** |
| D9 | Reach the first businesses by email and advertising | Unsolicited email is legally constrained; ads lead to the Sandbox, where the visitor opts in (section 7.4) |
| D10 | Gate thresholds in section 4 and the €500/month cap accepted | Treated as fixed until the founder changes them |
| D11 | The niche does not change the platform: it changes only the category pack, ad targeting and demo credibility. Decided 2026-10-25: garden care gets the deep pack, septic servicing is the second ad-test niche; the ad test confirms or overturns this | One deep pack in Phase 0, shallow packs for the other categories |
| D12 | Primary channel for Gate G1: concierge demo-on-request via ads (accepted 2026-10-25) | Request-a-demo page in Phase 0 (section 7.4, epic REQ); email only if cleared at G0 |
| D13 | Founder view: the admin part (leads list, online booking, mini-shop admin) is the same for every niche and is a core part of the product | Built as shared modules plugged in through blueprint module modes; build order adopted as an assumption on 2026-10-25: leads page in Phase 2, booking and mini-shop admin in Phase 3 after G3 |
| D14 | No lawyer is available; legal questions are answered by conservative defaults | Policy in section 4.1; residual risk accepted by the founder; templates in Appendix B to be reviewed when a qualified person is available |
| D15 | Offers and price points are hypotheses to test (section 20.2) | Two offers tested at Gate G2 |
| D16 | Total budget cap €500/month, allocated as in section 20.1 | Ads test pool €300 with stop rules |

## 4. Validation gates

Thresholds G2, G3 and G-L were accepted by the founder on 2026-10-24; G0 and G1 were revised on 2026-10-25 for the request-based channel and the absence of a lawyer (assumptions made on the founder’s behalf). All can be adjusted. They are decision points, not forecasts. Do not build beyond the current phase until its gate passes.

| Gate | When | Evidence required | If missed |
| --- | --- | --- | --- |
| G0 Outreach rules | Before the first outreach message | Conservative policy of section 4.1 adopted and built into the product: no unsolicited commercial email, contact only on request, no scraping, no purchased lists. Residual legal risk accepted by the founder because no lawyer is available | Do not contact anyone until the policy is implemented |
| G1 Demo resonance | After Phase 0 | At least 10 demo requests from real businesses in the target niches within 6 weeks of the ads starting, and at least 3 delivered demos leading to a call, meeting or price question | Change one variable (niche, ad message or demo quality) and run one more ad round with a new pool; if missed again, stop or pivot |
| G2 Willingness to pay | After Phase 1 | At least 2 prospects confirm a paid pilot in writing, tested at 2 or more price points, within 8 weeks of G1 | 0 pilots: rethink the offer or stop; 1 pilot: one more 4-week iteration |
| G-L Legal readiness | Before the first invoice | Legal form and tax registration (an accountant or a business counter can advise), employer-contract check for side activity (do it before ads start), terms, privacy policy and data-processing terms (templates in Appendix B) | No invoicing until resolved. This document is not legal advice |
| G3 Sustainability | 60 days after the first payment | At least 2 customers still paying; founder minutes per customer per month recorded | Continue, scale or stop; set the support-time limit after the first 3 customers |

### 4.1 Conservative operating policy (no lawyer available)

These rules are operating constraints for the MVP. They do not establish legal compliance or replace qualified advice. Gate G-L remains a separate launch prerequisite.

1. No unsolicited commercial email, SMS or messaging, by the product or by the founder.
2. Contact starts only when a business submits the request-a-demo form with consent, or replies to a message it asked for.
3. No scraping and no purchased or compiled contact lists. Market research on public listings is manual and stores only a business name and a link.
4. The demo is built only from what the requester typed about their own business.
5. Every email carries the sender identity and the footer from Appendix B. A STOP reply is honoured immediately and the data is deleted within 7 days.
6. At most two follow-up emails after the demo, within 14 days, and none after a STOP reply.
7. Ads use platform targeting only: no custom audiences built from personal data, no pixels, no non-essential cookies. The request page uses only strictly necessary storage.
8. Before ads start: privacy notice, consent text and an imprint with the operator’s identity are published; the employer-contract check is done; the AI and ad budget caps are configured.
9. Personal conversations (in person or by phone) are outside this spec and the founder’s own responsibility.
10. Once customers exist, the founder processes their enquiry data: a short data-processing clause goes into the pilot agreement (outline in Appendix B).
11. When budget allows, ask an accountant or a business counter about registration and tax, and a lawyer to review the templates.

## 5. Scope

### 5.1 Phases

| Phase | Goal | Contents | Rough effort | Gate |
| --- | --- | --- | --- | --- |
| 0 Demo Factory | A convincing demo for any prospect of the chosen niche | Blueprint schema, one deep niche pack, one template, generation and validation, static export, simple internal page or CLI, request-a-demo landing page with form and protected request inbox, expiring demo links and delivery log | 70–105 h, re-estimate after review | G1 |
| 1 Studio and Sandbox | Fast demo production and follow-up; the lead magnet | Operator Studio (projects, editing, AI revise, revisions, preview and share, pipeline); public Sandbox (English and French) with abuse controls and UTM attribution | 80–120 h | G2 |
| 2 Pilot Operations | Deliver and support the first paying sites | Production publishing, lead form and email, manual domain runbook, backups, monitoring, manual billing record, read-only leads page for customers | 60–95 h | G3 |
| 3 Growth (not specified here) | After G3 | Shared admin modules, identical for every niche: customer portal with leads list, online booking, mini-shop admin; billing automation | — | — |

Effort figures are rough planning estimates by the author of this spec, not commitments. At 20–30 h/week, Phases 0–2 total roughly 7–16 weeks of build time; the 6-week G1, 8-week G2 and 60-day G3 observation windows add calendar time. Re-estimate Phase 0 after splitting secure delivery, retention and access controls into tasks.

### 5.2 Out of scope for the MVP

- Customer accounts, interactive login and self-serve editor. Phase 2 includes the restricted bearer-link leads page in LEAD-006.
- Automated billing, webhooks and entitlements.
- Native booking, SMS, deposits; checkout, inventory, shipping.
- Automatic domain provisioning.
- Import from existing websites or Google listings; scraping of business data.
- Teams, roles, agency white-label.
- Arbitrary customer HTML or JavaScript.
- Analytics beyond first-party aggregate counts.
- A multilingual Studio UI (English only).

## 6. Needs detection and capability model

### 6.1 Inputs

Business category (from the category-pack list), business name, city or service area, a description of 1–5 sentences, content language, an optional “What should visitors do?” (call, WhatsApp, request a quote, book an appointment, browse a catalogue, buy online) and optional owner-provided facts (phone, email, opening hours, services, prices).

### 6.2 SiteBlueprint (generated, operator-editable)

| Field | Meaning |
| --- | --- |
| `category`, `locale` | From the pack and the input |
| `goals[]` | Ranked visitor goals: call, message, quote\_request, booking, catalogue, purchase |
| `modules` | For landing, catalogue, booking and shop: mode is none, demo\_mock, external\_link or native |
| `admin_need` | none, content\_updates, frequent\_updates or self\_service. A sales signal about how much ongoing editing the business needs; it drives the support plan, not a feature |
| `pages[]` | Pages with sections from the allowlist |
| `tone`, `design_preset` | From the pack and the input |
| `confirmed_facts` | Facts supplied or confirmed by the owner; only these may appear as factual claims |
| `rationale`, `confidence` | Why this blueprint was chosen; shown to the operator |

### 6.3 Capability matrix

| Need | In a demo | After sale (MVP) | Later |
| --- | --- | --- | --- |
| Landing page | Fully rendered | Fully rendered and published | — |
| Quote or contact request | Form rendered; submission simulated, nothing stored | Real form with validation, spam control and email to the owner | Lead dashboard |
| Catalogue without checkout | Generated placeholder items, marked as demo | Items entered by the operator; order-request form | Catalogue manager |
| Booking | Mock section with example slots, marked as demo | Button linking to a third-party booking tool the customer uses | Native booking |
| Online shop | Catalogue plus a mock Buy button, marked as demo | External checkout or payment link per product, or order-request form | Native checkout |
| Admin and self-service editing | Not shown | Change requests handled by the founder under the support plan | Customer portal |

Rule: a demo may show a capability only as a clearly labelled mock. It must never imply that the business offers prices, slots or stock it did not provide.

### 6.4 Detection logic

1. Deterministic rules map category and selected goals to default module modes defined in the pack.
2. An LLM call reads the description and proposes adjustments (for example “appointments” leads to a booking mock; “we deliver custom cakes” leads to catalogue plus quote request) and returns a rationale and confidence.
3. The server validates the result against the blueprint schema and rejects unknown modules.
4. In the Studio the operator can override any field before generation. In the Sandbox only the visitor’s inputs are used and the result is not editable.

## 7. User journeys

### 7.1 Sandbox visitor

1. Opens the Sandbox and chooses a business area.
2. Enters name, city, a short description and language; passes a bot check.
3. Sees progress, then a demo preview (target at most 60 s, to validate).
4. Can switch between desktop and mobile preview. The demo carries the watermark “Demo – not a live website”.
5. Clicks “I want this site” and leaves an email (optional phone) next to a consent text; the founder receives a lead.
6. The demo expires after 14 days unless it becomes a project.

### 7.2 Operator (founder)

1. Creates a prospect (name, category, city, notes, contact channel) and a project.
2. Enters the description and facts supplied by the requester. Public listings may support market research as in section 4.1, but are not a source for demo content.
3. Generates; reviews the blueprint and rationale; adjusts; regenerates if needed.
4. Edits sections manually or asks AI to revise one section; accepts or rejects the diff.
5. Creates a demo link (unlisted, expiring), emails it to the requester from a dedicated sending domain with SPF, DKIM and DMARC, with the footer from Appendix B, and logs the contact.
6. Tracks replies and demo views in the pipeline; records outcomes and objections.
7. After agreement: collects confirmed facts and assets, finalises content, publishes to a subdomain, connects the production domain via the runbook and activates lead notifications.
8. Handles change requests and logs founder minutes per request.

### 7.3 Site visitor

Opens the published site, uses call, WhatsApp or email buttons or the enquiry form, and sees a clear success or safe-failure message.

### 7.4 Acquisition channels

Decision D12: the primary channel for Gate G1 is concierge demo-on-request (B0). Email delivers requested demos and the consented follow-ups only. Channel A is excluded from this MVP; G0 does not enable an exception. The automated Sandbox (B) follows in Phase 1.

| Channel | How it works | Constraints | Phase |
| --- | --- | --- | --- |
| A. Outbound email with a personalised demo | Not used in the MVP: no unsolicited commercial email (section 4.1) | Indicative sources point to prior consent being required in Belgium, with narrow exceptions; with no adviser available the MVP avoids the channel. Reconsider once a qualified person has reviewed it | 0 |
| B. Advertising to the automated Sandbox | Ads lead owners to the Sandbox, which generates a demo; the visitor opts in by leaving an email next to a consent text | Best fit for consent, because the contact is volunteered. Needs Phase 1, a privacy policy, a fixed test budget and a stop rule. No ad pixels in the MVP; attribution by UTM parameters | 1 |
| C. Non-email outreach (phone, visit, referrals) | The founder presents the demo on a call or in person | Outside this spec: personal, low-volume conversations are the founder’s own responsibility; no lists, no recordings and no scripts stored in the product | 0 |
| B0. Concierge demo on request (primary for G1) | Ads lead to a static request-a-demo page. The visitor submits business name, category, city and a short description; the founder generates the demo with the Demo Factory and emails the demo link | Consent is given by the request, with consent text covering the demo and a limited follow-up (wording checked at G0). No public AI endpoint, so no abuse or cost risk. No ad pixels; UTM attribution. Needs a fixed test budget and a stop rule | 0 |

Target market: Wallonia, French-language offer (decided 2026-10-25). These notes come from third-party pages, some dated and some from email-marketing vendors; they are indicative and not legal advice.

## 8. Functional requirements

Phase tags: \[0\] Demo Factory, \[1\] Studio and Sandbox, \[2\] Pilot Operations. P0 is required in the tagged phase; P1 is next. AC means acceptance criteria.

### Epic NEED: blueprint and needs detection

- **NEED-001** \[0\]\[P0\] Versioned, validated blueprint schema (section 6.2).
- **NEED-002** \[0\]\[P0\] Category packs are data files: default goals, module modes, sections, tone, service suggestions, FAQ topics, forbidden claims.
- **NEED-003** \[0\]\[P0\] Rule-first detection with LLM adjustment; rationale and confidence stored.
- **NEED-004** \[1\]\[P0\] Operator can override blueprint fields before generation.
- **AC:** In Phase 0, a garden-care brief with goal quote_request produces a landing blueprint with a contact section; modules whose renderers are not available remain disabled. In Phase 1, a booking goal selects demo_mock and renders a labelled booking example; a catalogue goal selects the catalogue section. No phase enables native booking or checkout.

### Epic GEN: generation and validation

- **GEN-001** \[0\]\[P0\] Generate site JSON from blueprint, confirmed facts and pack through a provider adapter; output must conform to the versioned site schema.
- **GEN-002** \[0\]\[P0\] Bounded retry on invalid output, then a clear recoverable error.
- **GEN-003** \[0\]\[P0\] Fact-grounding validator (section 11.3).
- **GEN-004** \[0\]\[P0\] Descriptions and uploaded text are data and never alter system instructions.
- **GEN-005** \[0\]\[P0\] Record provider, model, prompt version, token usage, estimated cost, latency and outcome per job.
- **GEN-006** \[1\]\[P0\] Section-level AI revision returns only the selected section; the server merges it and all other sections stay byte-identical.
- **GEN-007** \[1\]\[P1\] Two variants per generation.
- **AC:** Given a brief without a phone number, when a site is generated, then no phone number appears and the contact section shows a placeholder flagged “missing”. Given a model output with an unknown component type, then validation fails and the previous valid draft is unchanged.

### Epic RND: templates and rendering

- **RND-001** \[0\]\[P0\] One responsive, accessible landing template with allowlisted sections: header, hero, services, about, process, gallery, testimonials (owner-provided only), FAQ, service area, contact and CTA, footer.
- **RND-002** \[0\]\[P0\] Server-side rendering of site JSON to static HTML and CSS (Qute) with escaping at render time and no third-party scripts.
- **RND-003** \[0\]\[P0\] Design presets through tokens (colours, locally hosted fonts from an allowlist, spacing).
- **RND-004** \[1\]\[P0\] Catalogue and quote-request sections; booking and shop mock sections.
- **RND-005** \[0\]\[P0\] Non-photographic visuals by default (icons, shapes, gradients); photos only when uploaded by the operator.
- **RND-006** \[0\]\[P0\] Locale-aware rendering for English and French: lang attribute, French typographic rules (non-breaking space before : ; ! ? and « » quotation marks), local date and phone formats.
- **AC:** Rendering the same site JSON twice gives identical output. Automated accessibility score is at least 90 on the reference template, with no serious or critical automated findings. Manual keyboard, focus, form-label and contrast checks must also pass; the score alone does not establish WCAG conformance.

### Epic SBX: public sandbox

- **SBX-001** \[1\]\[P0\] Flow as in section 7.1.
- **SBX-002** \[1\]\[P0\] Bot protection, per-IP and per-email rate limits, and a global daily AI budget with automatic shutoff.
- **SBX-003** \[0\]\[P0\] All shared demos are unlisted (cryptographically random token with at least 128 bits of entropy, stored only as a hash), noindex, watermarked and expire after 14 days. Expiry and revocation are checked before serving any demo document or private asset; knowing a storage path must not bypass access checks. Sandbox creation uses this facility in Phase 1.
- **SBX-004** \[1\]\[P0\] Email capture with explicit consent text; creates a prospect with source “sandbox”.
- **SBX-005** \[1\]\[P0\] Cache only within the same project or anonymous request capability, using the complete generation-input key in section 11.4. Never reuse one business’s generated content or contact facts for another requester.
- **SBX-006** \[1\]\[P0\] Sandbox UI and generated demos in English and French.
- **SBX-007** \[1\]\[P0\] Capture UTM parameters with each Sandbox request for ad attribution; no advertising pixels or third-party cookies in the MVP.
- **AC:** An exhausted daily budget blocks calls until the next UTC day; an exhausted monthly budget blocks them until the next UTC month. The response gives the applicable reset time rather than promising tomorrow for a monthly limit. Expired and revoked demo URLs return 410, including through direct asset requests.

### Epic REQ: concierge demo request

- **REQ-001** \[0\]\[P0\] Static request-a-demo page in English and French with a form: business name, category, city, a description of 1–5 sentences, contact email, consent checkbox with text, bot check; UTM parameters captured.
- **REQ-002** \[0\]\[P0\] Requests are stored and listed in an operator inbox (a Studio page or a simple admin view); the founder is notified by email. Unprocessed requests are deleted 30 days after receipt.
- **REQ-003** \[0\]\[P0\] A request creates a prospect with source ad\_request and logs funnel events: request\_submitted, demo\_sent, demo\_viewed.
- **REQ-004** \[0\]\[P0\] The founder fulfils each request manually with the Demo Factory and emails the demo link; target reply within one working day (to validate).
- **REQ-005** \[0\]\[P0\] Protect the inbox, brief contents and fulfilment actions from public access using a localhost-only CLI or authenticated single-operator view. A deployed view uses STU-001 security requirements from Phase 0. Log demo delivery and replies so G1 can be measured without the full Studio.
- **REQ-006** \[0\]\[P0\] Store consent timestamp, notice version, granted purpose and withdrawal timestamp. Suppress follow-ups immediately on withdrawal, then delete the request, related prospect notes, demos and queued messages within 7 days unless a separately documented retention duty applies. Processed requests expire 60 days after delivery; unprocessed requests expire 30 days after receipt. Customer conversion keeps only information needed for the customer relationship.
- **AC:** A valid submission creates one request and prospect with source ad_request, records consent evidence and UTM data, and queues the founder notification. Missing consent or a failed bot check stores no request or prospect. Public requests to inbox and fulfilment actions are denied. A replay using the same idempotency key creates no duplicate. Withdrawn consent cancels queued follow-ups; retention jobs delete expired records and their related demo content.

### Epic STU: Operator Studio

- **STU-001** \[1\]\[P0\] Single-operator authentication (magic link or OIDC for one allowlisted email), secure session, rate limits.
- **STU-002** \[1\]\[P0\] Project create, read, update, archive and delete with the states in section 10.
- **STU-003** \[1\]\[P0\] Form-based section editor generated from section schemas; reorder; show and hide.
- **STU-004** \[1\]\[P0\] Every save is a revision; any revision can be restored; a published revision is immutable.
- **STU-005** \[1\]\[P0\] Server-rendered desktop and mobile preview.
- **STU-006** \[1\]\[P0\] Demo links: create, expire, revoke; view tracking.
- **STU-007** \[1\]\[P0\] Asset upload with type and size limits and image re-encoding.
- **STU-008** \[1\]\[P0\] Usage and cost view per project and in total.
- **STU-009** \[2\]\[P0\] Change-request log with founder minutes.
- **STU-010** \[1\]\[P1\] Undo and redo.

### Epic PIPE: sales pipeline

- **PIPE-001** \[1\]\[P0\] Prospect statuses: new, demo\_created, demo\_sent, viewed, replied, call\_held, pilot\_offered, pilot\_accepted, paying, lost, churned; timestamped history.
- **PIPE-002** \[1\]\[P0\] Outreach log entry: date, channel, message-variant label, outcome, objection tag, notes (manual entry).
- **PIPE-003** \[1\]\[P0\] Funnel report: counts and conversion per status, filterable by niche, message variant and price point.
- **PIPE-004** \[0\]\[P0\] Record demo fetch counts server-side, excluding known bots and operator previews. Counts are approximate views, not unique people or verified engagement; no persistent visitor identifiers or cookies. Phase 1 adds the Studio report. G1’s substantive responses are recorded manually.

### Epic PUB: publishing and domains

- **PUB-001** \[2\]\[P0\] Publish an immutable, validated revision to static storage with an atomic switch; a failed publish keeps the previous version.
- **PUB-002** \[2\]\[P0\] Platform subdomain per site.
- **PUB-003** \[2\]\[P0\] Unpublish and suspend.
- **PUB-004** \[2\]\[P0\] Custom domain through an operator runbook: checklist with DNS records, verification and TLS status fields, and a hostname conflict check.
- **PUB-005** \[2\]\[P0\] Publication is blocked while placeholders flagged “missing” remain or a required contact fact is absent.
- **PUB-006** \[2\]\[P0\] SEO basics: title, description, canonical URL, sitemap, robots.txt, favicon, social preview, image alt text.
- **PUB-007** \[2\]\[P1\] Rollback to the previous published revision from the UI (a manual redeploy is acceptable in P0).
- **AC:** Given a failed publish, the previously published site stays online unchanged.

### Epic LEAD: enquiries

- **LEAD-001** \[2\]\[P0\] Public enquiry endpoint per site with server-side validation, honeypot, rate limit and bot check.
- **LEAD-002** \[2\]\[P0\] Store the lead scoped to customer and project for 30 days, then delete automatically; send the owner notification through a retryable queue.
- **LEAD-003** \[2\]\[P0\] Telephone, email and WhatsApp actions use validated destinations.
- **LEAD-004** \[2\]\[P0\] Operator can view leads per site; no public endpoint exposes leads.
- **LEAD-005** \[2\]\[P1\] Weekly lead digest for the owner.
- **LEAD-006** \[2\]\[P0\] Read-only leads page for customers: a bearer link with at least 128 bits of random entropy, stored hashed in `lead_view_link`, scoped to one project and expiring after 30 days. Operator can revoke and rotate it. Enforce scope and expiry on every data request, with no-store caching and no-referrer policy; redact tokens from logs and exclude third-party resources. Invalid or cross-project access discloses no enquiry data. No customer accounts or interactive login.

### Epic OPS: billing record and operations

- **BILL-001** \[2\]\[P0\] Manual customer and subscription record (plan label, price, start, status). The payment link is created outside the app. Automated billing is Phase 3, after G3 and G-L.
- **OPS-001** \[0\]\[P0\] Structured logs with correlation IDs.
- **OPS-002** \[2\]\[P0\] Daily database backup to object storage and one tested restore before the first paying customer.
- **OPS-003** \[2\]\[P0\] Uptime monitoring for published sites and the control plane, with email alerts.
- **OPS-004** \[0\]\[P0\] Secrets outside source control; dependency and secret scanning in CI.

## 9. Architecture

### 9.1 Style

A modular monolith in Quarkus with these modules: Blueprint and Packs, Generation, Rendering, Studio API, Sandbox API, Publishing, Leads, Pipeline, Notifications, Usage and Audit. One Angular app with two route areas: the public Sandbox and the Operator Studio. Background jobs run in the same process and are persisted in an `async_job` table (polling with row locking, `FOR UPDATE SKIP LOCKED`); there is no message broker. Published sites are static files produced by the renderer, so there is no site runtime.

### 9.2 Components

| Component | Choice | Notes |
| --- | --- | --- |
| Control plane | Quarkus (current LTS) | Modular monolith; jobs in-process |
| Frontend | Angular | Sandbox pages kept lightweight |
| Renderer | Qute templates plus precompiled CSS in the Quarkus codebase | Output is HTML and CSS only |
| Database | PostgreSQL | Migrations from day one |
| Object storage | S3-compatible | Assets, rendered output, backups |
| LLM | Provider adapter; model chosen by evaluation (section 11.5) | A small, fast model for the Sandbox and a stronger one for Studio generation, only if evaluation shows the value |
| Email | Transactional provider, EU region if available | Lead notifications and magic links |
| Bot protection | Privacy-friendly challenge (for example Turnstile or equivalent) | Sandbox and enquiry forms |
| Hosting | ADR-001, Option A adopted in OD-2 | Provision the minimum secure demo host before Phase 0 ads; production operations follow in Phase 2 |

### 9.3 ADR-001: hosting (Option A adopted in OD-2)

- **Option A (recommended for MVP):** one small EU VPS running Docker Compose with Quarkus, PostgreSQL and Caddy. Caddy serves the rendered sites and issues certificates on demand for approved hostnames. Cheapest and simplest. Risk: single point of failure; mitigate with backups, monitoring and a documented rebuild.
- **Option B:** S3 plus CloudFront with a certificate per custom domain. Better availability; more manual steps per domain.
- **Option C:** edge static hosting such as Cloudflare Pages or R2. Check current custom-domain limits and pricing before choosing.

Option A is the recorded decision, subject to verifying actual cost before purchase. Options B and C are alternatives if the founder reopens that decision. Criteria: monthly cost, manual steps per new custom domain, availability, EU data location, lock-in.

### 9.4 Key rules

- Published sites never call AI or the control plane to render. Demos serve pre-rendered files through an access gate that enforces token expiry and revocation without calling AI. Demo origin files are private; cache lifetime cannot bypass access checks.
- Project-owned records carry `project_id`; customer ownership is resolved through the project, with `customer_id` nullable until conversion. Customer records are customer-scoped and acquisition records are prospect/request-scoped. Validate ownership on every relationship and query; global packs, operator and aggregate usage are not project-owned.
- AI output is untrusted until validated.
- Studio and public endpoints use separate security configuration and share no session.
- Jobs are idempotent and retryable.
- Demo and published hostnames live on a registrable domain separate from the Studio (cookie isolation and phishing-reputation isolation).

### 9.5 Repository layout (proposed)

```text
siteforge/
  apps/studio-web/            # Angular: sandbox and operator studio
  services/control-plane/     # Quarkus modules, renderer, jobs
  packages/site-schema/       # JSON Schemas, examples, fixtures
  packs/                      # category packs (data files)
  infra/                      # docker compose, caddy, backup scripts
  docs/                       # ADRs, runbooks (domain, publish, incident)
```

### 9.6 Commands and code conventions

No application scaffold exists yet. The following are proposed command contracts to establish and verify in TASK-001, run from the repository root; they are not commands that work in the current document-only folder. Pin Java, Quarkus, Node, Angular and PostgreSQL versions in the scaffold and lockfiles rather than depending on a moving “latest”.

| Purpose | Proposed command |
| --- | --- |
| Local infrastructure | `docker compose -f infra/compose.yaml up -d` |
| Backend development | `services/control-plane/mvnw -f services/control-plane/pom.xml quarkus:dev` |
| Backend tests and build | `services/control-plane/mvnw -f services/control-plane/pom.xml verify` |
| Install frontend dependencies | `npm --prefix apps/studio-web ci` |
| Frontend development | `npm --prefix apps/studio-web start` |
| Frontend tests | `npm --prefix apps/studio-web test -- --watch=false` |
| Frontend production build | `npm --prefix apps/studio-web run build` |
| Frontend lint | `npm --prefix apps/studio-web run lint` |
| Browser journey checks | `npm --prefix apps/studio-web run test:e2e` |

The npm scripts and lint/e2e tooling must be created and documented in TASK-001. Focused test commands are recorded with each implementation task. Do not report these checks as passing until their tools exist and have run.

Use Java records for immutable request/response values, constructor injection, package boundaries by capability, and Angular strict TypeScript. JSON fields follow the versioned schema; database columns use snake_case. No runtime source example exists yet: add a real validated-request example to the contributor documentation with the first endpoint rather than presenting speculative code as an established convention.

## 10. Data model (MVP)

Conventions: UUID identifiers; UTC timestamps; money as integer minor units plus ISO currency code; every tenant-owned table has `customer_id` (nullable before a sale); optimistic locking through a `version` column.

| Entity | Key fields | Notes |
| --- | --- | --- |
| operator | id, email | Single row in MVP |
| prospect | id, name, category, city, source (ad_request, sandbox, referral, manual_request), contact email and phone, status, status history, notes | Every contact must trace to a request or documented consent; no outbound source in the MVP |
| concierge_request | id, prospect_id, project_id (nullable until fulfilment), input_json, contact_email, locale, utm_json, consent_version, consented_at, withdrawn_at, status, delivered_at, expires_at | Phase 0 inbox; statuses RECEIVED, IN_PROGRESS, DELIVERED, FAILED, WITHDRAWN; retention in REQ-006 |
| customer | id, prospect\_id, legal name, contact fields, status | Created when a pilot is accepted |
| project | id, prospect\_id, customer\_id, slug, category, locale, status, blueprint\_id, current\_draft\_revision\_id, published\_revision\_id | Status: DRAFT, GENERATING, READY, PUBLISHING, PUBLISHED, SUSPENDED, FAILED, ARCHIVED |
| blueprint | id, project\_id, version, data\_json, rationale, confidence, created\_by (rules, ai, operator) | Section 6.2 |
| confirmed\_fact | id, project\_id, key, value, source (owner, operator), confirmed\_at | Only these may appear as factual claims |
| revision | id, project\_id, number, schema\_version, content\_json, change\_source (AI, USER, SYSTEM), validation\_status, errors\_json | Published revision is immutable |
| asset | id, project\_id, storage\_key, mime\_type, size\_bytes, alt\_text, source (owner\_provided, operator) | Re-encoded images only |
| demo\_link | id, project\_id (nullable for sandbox demos), token\_hash, revision\_id, expires\_at, revoked\_at, view\_count, last\_viewed\_at, source | Unlisted and noindex |
| sandbox\_request | id, ip\_hash, email (nullable), input\_json, blueprint\_hash, demo\_link\_id, cost\_minor, created\_at | Inputs kept 30 days |
| outreach\_event | id, prospect\_id, date, channel, variant\_label, outcome, objection\_tag, notes | Manual log |
| lead | id, customer\_id, project\_id, payload\_json, notification\_status, created\_at, expires\_at | Deleted after 30 days |
| domain | id, project\_id, hostname (unique, normalised), verification\_status, tls\_status, created\_at, verified\_at | Statuses set manually in MVP |
| subscription\_record | id, customer\_id, plan\_label, price\_minor, currency, started\_at, status, payment\_link\_ref, notes | Manual record |
| change\_request | id, project\_id, description, received\_at, done\_at, minutes\_spent | Feeds Gate G3 |
| usage\_event | id, project\_id (nullable), source (concierge, sandbox, studio), job\_type, provider, model, prompt\_version, input\_units, output\_units, cost\_minor, currency, latency\_ms, outcome, correlation\_id | Cost control |
| async\_job | id, type, status, attempts, idempotency\_key, input\_ref, result\_ref, error\_code, timestamps | In-process queue |
| audit\_event | id, actor, action, resource\_type, resource\_id, metadata\_json, created\_at | Operator actions |
| lead\_view\_link | id, project\_id, token\_hash, created\_at, expires_at, revoked\_at, last\_viewed\_at | Read-only leads page for the customer; LEAD-006 scope and expiry rules |

Data rules: unique constraints on normalised hostname, token hash and idempotency key. Retention defaults: concierge requests follow REQ-006; sandbox inputs 30 days; expired demo files deleted 7 days after expiry; leads 30 days; usage and audit metadata 12 months without brief contents, contact details or bearer tokens. Deletion requests are handled through a runbook covering related records, assets and queued notifications; backup retention and deletion propagation must be documented before collecting personal data.

## 11. AI contracts and guardrails

### 11.1 Jobs

| Job | Input | Output | Notes |
| --- | --- | --- | --- |
| `classify_blueprint` | Category, goals, description, confirmed facts | Blueprint adjustments, rationale, confidence | Small model |
| `generate_site` | Blueprint, confirmed facts, pack | Site JSON (pages, sections, props) | Schema-constrained |
| `revise_section` | One section, instruction, blueprint summary, facts | The same section, revised | Other sections are never sent for editing |

### 11.2 Output rules

Versioned JSON Schema; allowlisted section and action types; length limits; URL schemes limited to https, tel, mailto and WhatsApp links; no scripts or HTML in text fields; CTA targets must exist; no unknown properties.

### 11.3 Fact grounding (GEN-003)

1. Extract candidates from generated text with deterministic patterns: phone numbers, emails, URLs, street addresses and postcodes, years, currency amounts, percentages, “since” and “established” phrases, and certification keywords from the pack.
2. Each candidate must match a confirmed fact after normalisation.
3. Review and testimonial sections render only from owner-provided items.
4. Qualitative copy (“reliable”, “careful”) is allowed. Statements of fact about experience, years, guarantees, prices, availability, licences or insurance are not, unless confirmed.
5. On violation: regenerate with feedback (at most 2 times), then fall back to a placeholder flagged “missing”. Placeholders block publication but not demos; in demos they render as visibly marked example text.

### 11.4 Prompting and security

Prompts are versioned in source control. Descriptions and uploads are wrapped as data, and the system prompt states the untrusted-data policy. No secrets and no other customer’s data enter a prompt. Logs hold metadata; full inputs are stored only under the retention rules. A cache key includes project/request scope, job type, complete normalised input (including confirmed facts and locale), pack version, provider/model identifier, prompt version and schema version. A changed phone number, locale, model or pack invalidates the hit. Cache entries follow the source retention and deletion rules; anonymous capabilities never share generated business content.

### 11.5 Evaluation

Fixture set: at least 5 briefs for the deep-pack niche and at least 1 for each shallow category, in every supported language. Metrics: schema validity, grounding violations (target 0), required sections present, CTA correctness, language quality, cost and latency. Language quality is judged only by a reviewer who masters the language; if the founder cannot judge a language, a native reviewer is required before outreach in it. Run the set before any prompt or model change and store the results.

### 11.6 Cost control

Per-job token caps, a Sandbox daily budget and per-IP limits, cached results, a usage event for every call, and an alert at 80% of the daily and monthly budget. Budget values are set by the founder (OD-5).

The monthly AI cap applies to classification, generation, repair and revision across concierge, Sandbox and Studio. Reserve the maximum estimated call cost atomically before dispatch; concurrent jobs cannot all spend the same remaining balance. Reconcile reservations to actual usage and keep uncertain provider charges reserved pending reconciliation. Provider-side limits are a second control where available; local estimates alone cannot guarantee the provider invoice. UTC day/month boundaries determine resets. A pending concierge request remains queued when generation is paused, and its delivery estimate is updated before the founder promises a date. The daily amount and Phase 1 monthly allocation must be configured before public Sandbox launch (section 23).

## 12. API outline

Prefix `/api/v1` for the authenticated Studio and `/public/v1` for unauthenticated endpoints, with separate security rules. Errors use one shape: `code`, `message`, `correlationId`, `fieldErrors`. Write the OpenAPI document before implementation.

**Public**

- `POST /public/v1/demo-requests` accepts the Phase 0 concierge form with server-side consent, bot, size and idempotency checks; returns an opaque receipt, never the inbox contents.
- `POST /public/v1/sandbox/demos` creates a demo request.
- `GET /public/v1/sandbox/demos/{requestId}` polls status.
- `POST /public/v1/sandbox/demos/{token}/interest` leaves contact details.
- `POST /public/v1/sites/{siteSlug}/leads` submits a site enquiry.
- `GET /d/{token}` serves pre-rendered demo HTML after expiry and revocation checks; related private assets use the same capability gate.
- `GET /l/{token}` and `GET /l/{token}/enquiries` serve the restricted customer leads view and its data under LEAD-006. No project selector can broaden the token scope.

**Studio**

- `GET /api/v1/demo-requests`, `POST /api/v1/demo-requests/{id}/fulfil`, `POST /api/v1/demo-requests/{id}/withdraw` support the Phase 0 protected inbox if a web view is chosen; a localhost-only CLI may provide the same operations instead.
- `POST /api/v1/auth/magic-link`, `POST /api/v1/auth/logout` (or OIDC).
- `GET|POST /api/v1/prospects`, `GET|PATCH /api/v1/prospects/{id}`, `POST /api/v1/prospects/{id}/outreach`.
- `POST /api/v1/projects`, `GET|PATCH|DELETE /api/v1/projects/{id}`.
- `POST /api/v1/projects/{id}/blueprint`, `POST /api/v1/projects/{id}/generate`, `GET /api/v1/jobs/{jobId}`.
- `GET|POST /api/v1/projects/{id}/revisions`, `POST /api/v1/projects/{id}/revisions/{n}/restore`.
- `POST /api/v1/projects/{id}/ai-revise`, `POST /api/v1/projects/{id}/preview`.
- `POST /api/v1/projects/{id}/demo-links`, `DELETE /api/v1/demo-links/{id}`.
- `POST /api/v1/projects/{id}/assets`.
- `POST /api/v1/projects/{id}/publish`, `POST /api/v1/projects/{id}/unpublish`.
- `GET|POST /api/v1/projects/{id}/domains`, `PATCH /api/v1/domains/{id}`.
- `GET /api/v1/projects/{id}/leads`, `POST /api/v1/projects/{id}/change-requests`.
- `GET /api/v1/reports/funnel`, `GET /api/v1/reports/usage`.

## 13. Non-functional requirements

**Security.** Server-side authorization on every operation; strict validation of inputs and AI output; secure cookies and CSRF protection for the Studio; CSP and security headers on published and demo sites; a separate content domain; no server-side fetching of user-supplied URLs in the MVP; upload type and size limits with re-encoding; rate limits on authentication, generation and forms; dependency and secret scanning in CI.

**Privacy.** Processors to document: LLM provider, email provider, hosting, bot-check provider. Data minimisation: Sandbox inputs kept 30 days, consent text next to email capture, no cookies on demos and published sites by default, no advertising pixels in the MVP (campaign attribution through UTM parameters). Once customers exist the founder acts for them as a processor of their enquiry data, so data-processing terms are required before pilots (Gate G-L). Check data location and transfers for the LLM provider. This is not legal advice.

**Performance.** Demo generation: target at most 60 s at p90 (to validate). Studio API: p95 under 500 ms for non-AI requests. Published pages: static, target “good” Core Web Vitals on a mobile reference device.

**Availability.** Published sites follow the hosting decision in ADR-001, with uptime monitoring. No uptime SLA is promised to customers in the MVP.

**Accessibility.** WCAG 2.1 AA target for the template: keyboard navigation, visible focus, labelled form fields, sufficient contrast, alt text.

## 14. Metrics

- **Funnel and learning:** sandbox\_started, demo\_generated, email\_captured; prospects by status; demos sent, viewed, replied; calls; pilots offered and accepted; paying; lost with objection tags.
- **Economics:** AI cost per demo and per project; founder minutes per project at setup and per customer per month; conversion by message variant and by price point; gross margin once paying (price minus AI, hosting and payment fees).
- **Quality:** generation success rate, grounding-violation rate, time to first demo, publish success rate, lead delivery success rate.
- **Weekly dashboard:** demos sent, views, replies, calls, pilots, paying customers, AI cost, hours worked.

## 15. Test strategy and Definition of Done

**Unit:** schema validation, grounding validator, URL and hostname validation, state transitions, renderer determinism.

**Integration:** PostgreSQL and migrations, object storage, email queue, AI adapter (mock and contract tests), publish and failed publish, token expiry.

**End-to-end:**

1. Sandbox demo from category to preview and interest capture.
2. Operator: create, generate, edit, preview, create a demo link, view recorded.
3. AI revision changes only the selected section.
4. Publish, submit a lead, notification queued.
5. Failed publish keeps the previous version online.
6. An AI provider outage does not affect published sites.
7. An exhausted daily budget blocks model calls.

**Definition of Done:** acceptance criteria met; inputs and outputs validated; tests pass; error and loading states exist; logs and metrics added; migrations tested; documentation and runbooks updated; no secrets in source; deployable and rollbackable; accessibility checked. AI features additionally need schema validation, a prompt version, usage telemetry and regression fixtures.

**Additional required scenarios:** Phase 0 request → protected inbox → generated demo → emailed expiring link; public inbox access denied; revoked/expired demo assets inaccessible; consent withdrawal cancels follow-ups; retention deletes related content; concurrent jobs respect budget reservations; monthly exhaustion does not promise a daily reset; changed facts miss the cache; another request cannot retrieve cached business content; lead-link rotation invalidates the old link and cannot expose another project.

**Boundaries for implementation:** Always validate untrusted input, enforce ownership, run the focused checks and document evidence. Ask before changing founder decisions, gate thresholds, the total budget, the stack or the privacy policy. Never add unsolicited outreach, fabricate business facts, commit secrets, weaken checks to get green, or implement later phases before their gates. Provider, domain and registration purchases require the founder’s action.

## 16. Implementation plan for Codex

Work one task at a time. Each task has acceptance criteria and tests. Do not hand the whole specification to the agent in one pass.

| Task | Phase | Deliverable | Done when |
| --- | --- | --- | --- |
| TASK-001 | 0 | Repository skeleton, CI, Docker Compose, Quarkus, Angular, PostgreSQL | CI green; health endpoint responds |
| TASK-002 | 0 | Site and blueprint JSON Schemas, fixtures, validation tests | Valid fixtures pass; invalid ones fail with clear errors |
| TASK-003 | 0 | Pack format, one deep pack, five shallow packs | Packs validate against the pack schema |
| TASK-004 | 0 | Qute landing template (English and French) and static renderer | Deterministic output; accessibility check passes |
| TASK-005 | 0 | AI adapter (mock and one provider), classify and generate jobs, grounding validator | Eval fixtures pass with zero grounding violations |
| TASK-006 | 0 | Internal page or CLI that produces a demo folder from a brief | Demo for a sample brief within the time target. Ads start only after TASK-006A, TASK-007 and the G0 preflight pass |
| TASK-006A | 0 | Request-a-demo page (English and French), consent evidence, bot check, UTM capture, protected inbox, retention and email notification | REQ-001 to REQ-006 AC; no ads until TASK-007 and the G0 preflight also pass |
| TASK-007 | 0 | Demo links: token, expiry, revocation, noindex, watermark, gated assets, approximate view counts and delivery log | SBX-003 and PIPE-004 AC; complete concierge journey verified before ads |
| TASK-008 | 1 | Studio authentication, prospects, projects, pipeline, outreach log, funnel report | STU-001, STU-002, PIPE-001 to PIPE-003 |
| TASK-009 | 1 | Section editor, revisions, preview, AI revise | GEN-006, STU-003 to STU-005 |
| TASK-010 | 1 | Public Sandbox UI and API with abuse controls, budget cap and caching | SBX-001 to SBX-007 AC |
| TASK-011 | 1 | Usage and cost tracking and report | STU-008. **Gate G2 work follows** |
| TASK-012 | 2 | Publish pipeline to the ADR-001 target; subdomain; unpublish | PUB-001 to PUB-003, PUB-005, PUB-006 |
| TASK-013 | 2 | Lead endpoint, storage with expiry, email queue | LEAD-001 to LEAD-004 |
| TASK-014 | 2 | Domain runbook, domain records and checklist UI | PUB-004 |
| TASK-015 | 2 | Backups, restore test, monitoring | OPS-002, OPS-003 |
| TASK-016 | 2 | Change-request log and subscription record | STU-009, BILL-001 |
| TASK-017 | 2 | Full end-to-end suite | All scenarios in section 15 pass |
| TASK-018 | 2 | Read-only customer leads page with hashed link token | LEAD-006 |

## 17. Risks

| Risk | Mitigation |
| --- | --- |
| No demand or weak sales execution | Gates G1 to G3; pipeline log to learn from every conversation; build only after evidence |
| Self-serve builders are cheap and widespread (see Appendix) | Sell the managed outcome and local support, not the tool |
| Language quality, or the outreach language is not one the founder masters | Choose a niche and language the founder can verify, or use a native reviewer (OD-1) |
| Unsolicited outreach or use of public business information breaks rules | Gate G0; no scraping of personal data; no copying of a prospect’s content; watermark and disclaimer on demos |
| A demo is mistaken for the business’s official site | Watermark, noindex, unlisted token, expiry, no real contact data unless supplied |
| Sandbox cost abuse | Bot check, rate limits, daily budget shutoff, caching |
| AI invents facts | Grounding validator; placeholders block publication |
| Support time grows faster than revenue | Track founder minutes; define plan limits; Gate G3 |
| Single-server outage | Backups, monitoring, documented rebuild; revisit hosting after pilots |
| Legal or tax exposure | Gate G-L before the first invoice |
| Scope creep into booking and shop | Capability matrix; Phase 3 starts only after a gate |
| Unrequested commercial email breaches the operating policy | No cold email, including generic company addresses; request and consent evidence required; authenticated sending domain for requested demos and permitted follow-ups |
| Ad spend is used up before the funnel is proven | Phase 0 ads start only after secure concierge delivery and G0 preflight work; fixed pool, niche stop rules and UTM attribution |
| No lawyer is available, so the legal assumptions may be wrong | Conservative policy (section 4.1); no unsolicited contact; templates in Appendix B reviewed when a qualified person is available; residual risk accepted by the founder |

## 18. Decision register (recorded assumptions and remaining prerequisites)

| ID | Decision | Needed by | Resolution (assumption) |
| --- | --- | --- | --- |
| OD-1 | First niche (languages fixed: English and French) | Start of Phase 0 | Resolved: garden care in Wallonia (French) gets the deep pack, because it has the larger pool of small businesses to advertise to; septic servicing is the second ad-test niche with a shallow pack; painters are the reserve; hair salons are excluded (booking platforms already cover them). The ad test confirms or overturns the choice |
| OD-2 | Hosting (ADR-001) | Start of Phase 2 | Resolved: Option A (one VPS with Docker Compose and Caddy) |
| OD-3 | LLM provider and model | During TASK-005 | Resolved: start with the Anthropic API (small tier for classification, mid tier for generation); evaluate one alternative on the same fixtures in TASK-005 and keep the adapter swappable |
| OD-4 | Legal form, tax, employer-contract check, terms, privacy policy | Employer check and public notices before ads; remaining G-L items before invoicing | Operating policy adopted; legal readiness remains unverified. The policy is not evidence that registration or other duties are satisfied |
| OD-5 | Ad test amount, taken from what remains of the €500 cap after infrastructure and AI, with a stop rule; Sandbox daily AI cap | Ads allocation before Phase 0; Sandbox limits before Phase 1 launch | Phase 0 allocation in section 20.1; daily Sandbox amount and Phase 1 AI allocation remain open in section 23 |
| OD-6 | Product name and domains, including a separate content domain | Before the Sandbox goes public | Resolved: keep SiteForge as the working name until ads start; check trademark and domain availability first; register a product domain and a separate content domain |
| OD-7 | Offer structure and price points to test | Before Gate G2 | Resolved: two offers in section 20.2 |

## 19. Appendix: reference prices and pricing hypotheses

Competitor prices have not been verified against current vendor pages. Before Gate G2, record dated sources, billing term, taxes and included services for relevant self-serve builders and local managed services; do not use unsourced historical prices in sales copy.

Self-serve tool prices alone do not establish willingness to pay for this managed service. Hypothesis to test, not evidence: a one-time setup fee plus a monthly support plan, tested at 2 or more price points. Agency price levels in the target market have not been verified and must be researched before Gate G2. Value proposition to test: a finished site, changes handled for you, one monthly price.

## 20. Budget allocation and offers (assumptions)

### 20.1 Budget (total cap €500/month)

| Item | Cap | Notes |
| --- | --- | --- |
| Hosting (one EU VPS, backups) | €25/month | Assumed amount; verify when ordering |
| Domains (product and content) and transactional email | €15/month | Annual fees spread over months |
| Monitoring and other tools | €10/month | Free tiers first |
| AI usage | €30/month in Phase 0 | Hard cap in configuration; measure the cost per demo in TASK-005 |
| Ads test pool | €300 once, over the first 4–6 weeks | Split 50/50 between garden care and septic servicing |
| Buffer | about €120 | Unallocated; absorbs overruns |

Stop rules:

- If a niche has no request after 30% of its pool (about €45), pause its campaign, rewrite the message once and relaunch with the rest of the pool.
- If daily spend exceeds twice the planned daily amount, pause the campaign.
- If the monthly AI cap is reached, all AI jobs pause until the next UTC month and concierge requests remain queued. The separate Sandbox daily cap resets the next UTC day, subject to monthly balance. Messages show the effective reset time.
- If fewer than 10 requests have arrived when the pool is spent, Gate G1 is missed (section 4).

A €300 pool buys only a small number of clicks. The test can reveal a clear failure but cannot measure small differences between the two niches; read the results as directional.

The €300 pool is total test spend across the 4–6-week experiment, not a fresh allowance each month. Track invoices and committed spend in each calendar month as well as the experiment total; infrastructure, AI, ads and tools together must stay within €500/month. A second G1 round needs a new founder-approved pool within that cap. The €120 buffer is unallocated headroom, not permission to exceed any configured cap.

### 20.2 Offers to test at Gate G2 (hypotheses)

| Offer | Setup fee | Monthly | Includes |
| --- | --- | --- | --- |
| A. Essential | €250 once | €29 | One-page site (up to 6 sections); hosting on a platform subdomain or on the customer’s own domain (domain fee paid by the customer); enquiry form with email notifications and the read-only leads page; up to 2 content changes per month; replies within 2 working days |
| B. Essential, no setup fee | €0 | €49 | Same as offer A |

Rules: monthly billing, cancel any time, no minimum term (avoids contract complexity). Each interested prospect gets one offer, chosen at random. The offer is presented in the founder’s reply to the demo, not on the request page. State whether prices include VAT after Gate G-L. These price points are hypotheses with no market evidence; agency price levels in Wallonia have not been verified (section 19).

## 21. Appendix A: request-a-demo page and ad copy

### 21.1 Page structure

1. Opening: name the demo offer, clarify that a person prepares and emails it, and link directly to the request form.
2. Explain what the requester receives and what information is needed. Use numbered steps only if they make the actual request and delivery sequence easier to follow.
3. Form.
4. Reassurance: free, no obligation, nothing is published as an official business website; information is used for the demo and the limited follow-ups described beside the consent checkbox (link to privacy notice).
5. Footer: operator identity (name, contact email, enterprise number once registered) and the privacy link.

Two variants (garden care, septic servicing) differ only in headline, subline, preselected category and example wording; form and logic are identical. Default language is French with an English switch.

### 21.2 Copy (draft)

| Element | French (primary) | English |
| --- | --- | --- |
| Headline | Voyez votre futur site avant de décider | See your future website before you decide |
| Subline, garden care | Décrivez votre activité de jardinage en 2 minutes. Recevez gratuitement la démo de votre site, sans engagement. | Describe your gardening business in 2 minutes. Get a free demo of your site, no obligation. |
| Subline, septic servicing | Décrivez votre entreprise de vidange en 2 minutes. Recevez gratuitement la démo de votre site, sans engagement. | Describe your septic servicing business in 2 minutes. Get a free demo of your site, no obligation. |
| Step 1 | Décrivez votre entreprise | Describe your business |
| Step 2 | Nous préparons la démo et confirmons le délai par e-mail | We prepare the demo and confirm the delivery time by email |
| Step 3 | Vous la recevez par e-mail et décidez librement | You receive it by email and decide freely |
| Button | Recevoir ma démo gratuite | Get my free demo |
| Success message | Merci ! Votre demande est enregistrée. Vous recevrez la démo par e-mail. | Thank you! Your request is registered. You will receive the demo by email. |

### 21.3 Form fields

| Field | Type | Rules |
| --- | --- | --- |
| `business_name` | text | Required, 2–80 characters |
| `category` | select | Garden care, septic servicing, other; preselected by page variant |
| `city` | text | Required, 2–60 characters |
| `description` | text area | Required, 20–600 characters; treated as untrusted data |
| `email` | email | Required, validated and normalised |
| `language` | hidden | fr or en, from the page language |
| `consent` | checkbox | Required; text in Appendix B |
| `website_url` | hidden honeypot | Must stay empty |
| `utm_*` | hidden | Source, medium, campaign and content captured from the URL |

No phone number, no file upload and no free text beyond the description (data minimisation).

### 21.4 Ad copy drafts (French; check character limits in the ads interface)

| Niche | Headlines (max 30 characters each) | Descriptions (max 90 characters each) |
| --- | --- | --- |
| Garden care | Un site pour votre jardinage; Démo gratuite pour jardiniers; Présentez vos services | Démo gratuite de votre futur site, sans engagement. Recevez votre aperçu par e-mail.; Décrivez votre activité de jardinage en 2 minutes : nous préparons la démo de votre site. |
| Septic servicing | Site web pour vidangeurs; Démo gratuite de votre site; Vos clients vous trouvent | Décrivez votre entreprise en 2 minutes et recevez la démo d’un site à votre image.; Site clair, bouton d’appel et formulaire de demande. Démo gratuite, sans engagement. |

Do not add delivery guarantees or claims of increased enquiries without evidence and a confirmed capacity to deliver. The one-working-day reply target is internal until validated.

UTM convention: `utm_source` = google or meta; `utm_medium` = cpc; `utm_campaign` = garden-wal-fr or septic-wal-fr; `utm_content` = variant letter.

## 22. Appendix B: templates (not legal advice)

Drafts for the founder to adapt. They have not been reviewed by a lawyer. Replace the bracketed items.

### 22.1 Consent text for the form

- **FR:** J’accepte que \[NOM DE L’OPÉRATEUR\] utilise les informations saisies (nom de l’entreprise, ville, description, e-mail) pour préparer une démonstration de site web et me l’envoyer par e-mail, et pour me recontacter au maximum deux fois à ce sujet dans les 14 jours. Je peux retirer mon accord à tout moment en écrivant à \[E-MAIL\]. Politique de confidentialité : \[LIEN\].
- **EN:** I agree that \[OPERATOR NAME\] uses the information I entered (business name, city, description, email) to prepare a website demo and email it to me, and to contact me at most twice about it within 14 days. I can withdraw my consent at any time by writing to \[EMAIL\]. Privacy notice: \[LINK\].

### 22.2 Email footer (every email)

- **FR:** Vous recevez ce message parce que vous avez demandé une démonstration de site web sur \[SITE\] le \[DATE\]. Expéditeur : \[NOM\], \[ADRESSE POSTALE ET NUMÉRO D’ENTREPRISE QUAND ILS EXISTENT\], \[E-MAIL\]. Pour ne plus recevoir de messages ou faire supprimer vos données, répondez STOP à cet e-mail.
- **EN:** You are receiving this message because you requested a website demo on \[SITE\] on \[DATE\]. Sender: \[NAME\], \[POSTAL ADDRESS AND ENTERPRISE NUMBER ONCE THEY EXIST\], \[EMAIL\]. To stop receiving messages or have your data deleted, reply STOP to this email.

### 22.3 Demo watermark and disclaimer

- **FR:** Démonstration générée par IA : ce n’est pas le site officiel de l’entreprise. Les contenus non confirmés sont indiqués comme exemples.
- **EN:** AI-generated demo: this is not the business’s official website. Unconfirmed content is labelled as an example.

### 22.4 Privacy notice outline

- **Who is responsible:** operator identity and contact email.
- **Data collected:** form fields, UTM parameters, a hashed IP address for rate limiting, server logs.
- **Purposes:** prepare and send the demo; follow up at most twice; prevent abuse; measure the funnel in aggregate.
- **Legal basis:** consent for the demo and the follow-up; legitimate interest for abuse prevention and security.
- **Recipients and processors:** hosting provider, email provider, AI provider (name each once chosen). The description text is processed by the AI provider.
- **Transfers outside the EU:** state them and use only providers whose data-processing terms cover them.
- **Retention:** unprocessed requests 30 days after receipt; processed requests 60 days after the demo is delivered unless the requester becomes a customer; aggregate statistics without personal data may be kept.
- **Rights:** access, correction, deletion, withdrawal of consent, and a complaint to the data protection authority (in Belgium, the Data Protection Authority).
- **Cookies:** none beyond strictly necessary storage.

### 22.5 Data-processing clause outline for pilot customers

- **Roles:** the customer decides the purposes of the enquiry data; the operator processes it to host the site and forward enquiries.
- **Scope and duration:** enquiries received through the site, kept 30 days.
- **Instructions:** processing only on the customer’s documented instructions.
- **Security:** access limited to the operator; measures from section 13.
- **Sub-processors:** hosting and email providers, listed; the customer is told about changes.
- **Assistance:** help with access and deletion requests from the customer’s visitors.
- **Breaches:** notify the customer without undue delay.
- **End of contract:** delete or return the data within 30 days.

## 23. Open decisions and approval boundary

These are unresolved prerequisites, not evidence that the product has passed a gate:

| Item | Needed before | Required outcome |
| --- | --- | --- |
| Capability boundaries and build order | Detailed implementation planning | Review a small capability map for the active phase before drafting any separate module specs. Section 16 is an inherited milestone inventory, not an approved executable task list |
| Phase 0 protected operator access | Planning the inbox slice | Choose localhost-only CLI or authenticated web view; both must fulfil REQ-005 |
| Daily Sandbox AI cap and Phase 1 monthly allocation | Public Sandbox launch | Founder-approved amounts within the €500 total cap, with reset and reservation tests |
| Versions and provider identifiers | TASK-001 / TASK-005 respectively | Pin supported framework/runtime versions; name actual evaluated models and their pricing inputs rather than “small” or “mid” tiers |
| Product and content domains, sender identity | Public request page and ads | Available domains and completed operator details; do not publish bracketed identity placeholders |
| Privacy and operating readiness | First collection of personal data / G-L as applicable | Complete notices, consent evidence, processor records, backup retention and deletion runbook; verify unresolved legal and registration requirements separately |
| Visual direction | Building the request page or generated template | Founder supplies or approves identity, typography, palette and tone. Record a Design Read and ENERGY / RHYTHM / MOTION before UI work; this spec is not a finished visual design |

Review scope: business model, languages, niches, recorded gate thresholds and total budget are preserved. Secure Phase 0 sharing, bounded customer lead links and the clarified cache/budget contracts are proposed implementation requirements for approval. Once this revision is approved, use `tasks/plan.md` and `tasks/todo.md` for the active phase; do not begin implementation as part of specification review.

### Specification delivery checks

- PASS, consistency: Phase 0 contains the request inbox, consent evidence and secure demo delivery needed for G1; automated Sandbox remains Phase 1.
- PASS, evidence and copy: removed unsourced competitor prices and unvalidated delivery/lead-growth promises; example business facts remain labelled and block production publishing until confirmed.
- PASS, scope: no application code, visual assets, external messages or purchases were produced during this refinement.
- PASS, verification honesty: commands are explicitly scaffold contracts; acceptance scenarios are specified, not reported as executed. Layout, interaction, contrast and motion checks require a running UI and remain implementation acceptance work.

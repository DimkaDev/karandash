# Graph Report - karandash  (2026-10-25)

## Corpus Check
- 27 files · ~73,670 words
- Verdict: corpus is large enough that graph structure adds value.
- Unclassified: 2 file(s) not represented in the graph (top: (none) 2)

## Summary
- 157 nodes · 179 edges · 11 communities (9 shown, 2 thin omitted)
- Extraction: 89% EXTRACTED · 11% INFERRED · 0% AMBIGUOUS · INFERRED: 19 edges (avg confidence: 0.84)
- Token cost: 0 input · 0 output

## Community Hubs (Navigation)
- Quality Gates and CI
- Frontend Performance and Observability
- SiteForge Product Architecture
- Incremental Delivery and Git
- Specification and Launch Workflow
- Design and Runtime Verification
- Security and Trust Boundaries
- Architecture Decisions and Review
- Design Direction and Grounding
- API Contracts and Validation
- Behavior-Preserving Simplification

## God Nodes (most connected - your core abstractions)
1. `Constraint-Driven Development` - 10 edges
2. `Security and Hardening` - 8 edges
3. `Floor Guard` - 7 edges
4. `Optimization Patterns` - 7 edges
5. `Shipping and Launch` - 7 edges
6. `SiteForge MVP` - 7 edges
7. `CI/CD and Automation` - 6 edges
8. `Code Review and Quality` - 6 edges
9. `Observability and Instrumentation` - 6 edges
10. `Performance Optimization` - 6 edges

## Surprising Connections (you probably didn't know these)
- `Structured AI Generation` --semantically_similar_to--> `Untrusted LLM Output`  [INFERRED] [semantically similar]
  spec.md → .agents/skills/security-and-hardening/SKILL.md
- `Consent and Retention Policy` --semantically_similar_to--> `Personal Data and Privacy`  [INFERRED] [semantically similar]
  spec.md → .agents/skills/security-and-hardening/SKILL.md
- `Atomic Publishing` --semantically_similar_to--> `Rollback Strategy`  [INFERRED] [semantically similar]
  spec.md → .agents/skills/shipping-and-launch/SKILL.md
- `Fact Grounding Validator` --semantically_similar_to--> `Real Content or Honest Placeholder`  [INFERRED] [semantically similar]
  spec.md → .codex/skills/antislop/SKILL.md
- `Structural Remedies` --semantically_similar_to--> `Code Simplification`  [INFERRED] [semantically similar]
  .agents/skills/code-review-and-quality/SKILL.md → .agents/skills/code-simplification/SKILL.md

## Hyperedges (group relationships)
- **Demo to Managed Site** — spec_concierge, spec_studio, spec_publishing, spec_static_sites, spec_leads [EXTRACTED 1.00]

## Communities (11 total, 2 thin omitted)

### Community 0 - "Quality Gates and CI"
Cohesion: 0.11
Nodes (8): CI/CD and Automation, Feature Flags, GitHub Actions, Code Review and Quality, Guard Exit Codes, Floor Guard, Constraint-Driven Development, CONSTRAINTS.md

### Community 1 - "Frontend Performance and Observability"
Cohesion: 0.09
Nodes (13): Design Contract, Frontend UI Engineering, WCAG 2.1 AA, Correlation IDs, Observability and Instrumentation, OpenTelemetry, RED and USE Metrics, Structured Logging (+5 more)

### Community 2 - "SiteForge Product Architecture"
Cohesion: 0.15
Nodes (20): Rollback Strategy, Angular Frontend, SiteBlueprint, Budget and Offer Experiments, Concierge Demo Request, Validation Gates G0 G1 G2 G-L G3, Structured AI Generation, ADR-001 EU VPS Hosting (+12 more)

### Community 3 - "Incremental Delivery and Git"
Cohesion: 0.13
Nodes (11): Atomic Commits, Git Workflow and Versioning, Git Worktrees, Semantic Versioning, Feature Flags, Incremental Implementation, Vertical Slices, Acceptance Criteria (+3 more)

### Community 4 - "Specification and Launch Workflow"
Cohesion: 0.12
Nodes (16): Error Budget Release Gate, Feature Flag Strategy, Launch Monitoring, Staged Rollout, Shipping and Launch, Human Approval Gates, Capability Map, Living Specification (+8 more)

### Community 5 - "Design and Runtime Verification"
Cohesion: 0.14
Nodes (5): Anti Slop, DESIGN.md Direction, Browser Testing with DevTools, Chrome DevTools MCP, Context Engineering

### Community 6 - "Security and Trust Boundaries"
Cohesion: 0.20
Nodes (12): Dependency Audit Triage, Data Classification, Destructive Path Ownership Checks, Hardening Patterns, Schema Validation at Boundaries, SSRF Allowlisting and DNS Rebinding, Untrusted LLM Output, Personal Data and Privacy (+4 more)

### Community 7 - "Architecture Decisions and Review"
Cohesion: 0.20
Nodes (7): Architecture Decision Records, Documentation and ADRs, OpenAPI, Artifact and Contract, Cross Model Escalation, Doubt Driven Development, Changelog

### Community 8 - "Design Direction and Grounding"
Cohesion: 0.25
Nodes (8): Anti Slop Core Filter, Delivery Gate, Energy Rhythm Motion Dials, Real Content or Honest Placeholder, During and After Modes, Purpose Test, Project Agent Skill Routing, Fact Grounding Validator

## Knowledge Gaps
- **42 isolated node(s):** `Idempotency Key`, `Chrome DevTools MCP`, `GitHub Actions`, `Feature Flags`, `Guard Exit Codes` (+37 more)
  These have ≤1 connection - possible missing edges or undocumented components. (Counts symbols only; 75 node(s) total have ≤1 connection when file, concept and rationale nodes are included.)
- **2 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Security and Hardening` connect `Security and Trust Boundaries` to `Specification and Launch Workflow`?**
  _High betweenness centrality (0.065) - this node is a cross-community bridge._
- **What connects `Idempotency Key`, `Chrome DevTools MCP`, `GitHub Actions` to the rest of the system?**
  _42 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Quality Gates and CI` be split into smaller, more focused modules?**
  _Cohesion score 0.1067193675889328 - nodes in this community are weakly interconnected._
- **Why does `Context Engineering` connect `Design and Runtime Verification` to `Quality Gates and CI`?**
  _High betweenness centrality (0.051) - this node is a cross-community bridge._
- **Should `Frontend Performance and Observability` be split into smaller, more focused modules?**
  _Cohesion score 0.09486166007905138 - nodes in this community are weakly interconnected._
- **Should `Incremental Delivery and Git` be split into smaller, more focused modules?**
  _Cohesion score 0.1323529411764706 - nodes in this community are weakly interconnected._
- **Should `Specification and Launch Workflow` be split into smaller, more focused modules?**
  _Cohesion score 0.125 - nodes in this community are weakly interconnected._
## Token accounting limitation

Subagent usage counters were unavailable. Token fields show zero placeholders, not measured usage; semantic extraction consumed session tokens.

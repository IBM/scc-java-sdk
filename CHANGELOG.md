# [5.0.0](https://github.com/IBM/scc-java-sdk/compare/4.0.0...5.0.0) (2025-05-16)


### Features

* access control segmentation ([c266070](https://github.com/IBM/scc-java-sdk/commit/c266070c390a53c89a93bf9e799d8b1e7b6a24cb))


### BREAKING CHANGES

* ScopeID is now required to create a new profile attachment

Signed-off-by: Bryan Bosely <bbosely@us.ibm.com>

# [4.0.0](https://github.com/IBM/scc-java-sdk/compare/3.0.0...4.0.0) (2023-09-15)


### Features

* SCC V2 Java SDK ([#54](https://github.com/IBM/scc-java-sdk/issues/54)) ([139f582](https://github.com/IBM/scc-java-sdk/commit/139f582b8bd48d34134a14603b17302632c790a6))


### Performance Improvements

* **SCC:** Releasing SCC v2 Java SDK ([de59ab2](https://github.com/IBM/scc-java-sdk/commit/de59ab2e0eb6de65ce9329fb58d0a073de5e6114))


### BREAKING CHANGES

* **SCC:** SCC v2 Java SDK

Signed-off-by: Gaurav Goswami <gouravgoswami48@gmail.com>

# [3.0.0](https://github.com/IBM/scc-java-sdk/compare/2.0.1...3.0.0) (2022-08-05)


### Bug Fixes

* **FindingsAPI:** deprecated ([fe11482](https://github.com/IBM/scc-java-sdk/commit/fe11482670f9fbaf0b37db1039b7416cef1607c4))


* Merge pull request #51 from IBM/si-deprecation ([7458078](https://github.com/IBM/scc-java-sdk/commit/7458078e97f35a158e72ad72ce861c01719ab598)), closes [#51](https://github.com/IBM/scc-java-sdk/issues/51)


### BREAKING CHANGES

* Deprecating Security Insights
* **FindingsAPI:** deprecating Security Insights

## [2.0.1](https://github.com/IBM/scc-java-sdk/compare/2.0.0...2.0.1) (2021-12-20)


### Bug Fixes

* **SCC:** deprecating NotificationsAPI ([54675b5](https://github.com/IBM/scc-java-sdk/commit/54675b52fb6b1e09d85aa03d32770d170f8b9ec4))

# [2.0.0](https://github.com/IBM/scc-java-sdk/compare/1.0.2...2.0.0) (2021-12-20)


* Merge pull request #49 from IBM/deprecate ([e8dbdaf](https://github.com/IBM/scc-java-sdk/commit/e8dbdaf1c7ba58c3172bbb5faa6b39b36e2ca8e7)), closes [#49](https://github.com/IBM/scc-java-sdk/issues/49)


### BREAKING CHANGES

* deprecating NotificationsAPI

## [1.0.2](https://github.com/IBM/scc-java-sdk/compare/1.0.1...1.0.2) (2021-12-10)


### Bug Fixes

* **FindingsAPI:** getOccurrence should not return list ([fb58f89](https://github.com/IBM/scc-java-sdk/commit/fb58f8987472915260a0348e52e95111c29c6787))

## [1.0.1](https://github.com/IBM/scc-java-sdk/compare/1.0.0...1.0.1) (2021-10-12)


### Bug Fixes

* **Findings:** createTime and updateTime in NoteOptions ([71dd5f1](https://github.com/IBM/scc-java-sdk/commit/71dd5f191ded6f7f0f5584687ac75a2fcbd6ff6f))
* **SemanticRelease:** latest SR needs node >= 14.17 ([0e66f85](https://github.com/IBM/scc-java-sdk/commit/0e66f85de27f0ccc6a0200530e78cf36b6a99de2))

# [1.0.0](https://github.com/IBM/scc-java-sdk/compare/0.0.33...1.0.0) (2021-06-30)


* Merge pull request #41 from IBM/major ([ecd24cd](https://github.com/IBM/scc-java-sdk/commit/ecd24cd02e44291f1803432d10fd06f65a01afa2)), closes [#41](https://github.com/IBM/scc-java-sdk/issues/41)


### BREAKING CHANGES

* Major release for GA

## [0.0.33](https://github.com/IBM/scc-java-sdk/compare/0.0.32...0.0.33) (2021-06-25)


### Bug Fixes

* **SDK:** TransactionID parameter to comply with findingsapi ([95ce915](https://github.com/IBM/scc-java-sdk/commit/95ce9153135bbc957da91f424c0d56da8337586c))

## [0.0.32](https://github.com/IBM/scc-java-sdk/compare/0.0.31...0.0.32) (2021-06-25)


### Bug Fixes

* **SDK:** regeneration after content review ([55d4dde](https://github.com/IBM/scc-java-sdk/commit/55d4ddec4c4a703a73c14571b6084b0b3f051c28))

## [0.0.31](https://github.com/IBM/scc-java-sdk/compare/0.0.30...0.0.31) (2021-06-24)


### Bug Fixes

* **GPG:** use passphrase while importing gpg keys ([87f1fdf](https://github.com/IBM/scc-java-sdk/commit/87f1fdf46104b9855024da1924c9dcd33ab8b4c2))

## [0.0.30](https://github.com/IBM/scc-java-sdk/compare/0.0.29...0.0.30) (2021-06-22)


### Bug Fixes

* **Maven:** added flags from gpg2 and gpg ([5ca1a71](https://github.com/IBM/scc-java-sdk/commit/5ca1a710bde27e42465ca7988c2fbd4f5d3c31b0))

## [0.0.29](https://github.com/IBM/scc-java-sdk/compare/0.0.28...0.0.29) (2021-06-22)


### Bug Fixes

* **MavenCentral:** gpg2 arguments in pom ([08085a6](https://github.com/IBM/scc-java-sdk/commit/08085a644802e6a2fe5313222a1c092453f33d15))

## [0.0.28](https://github.com/IBM/scc-java-sdk/compare/0.0.27...0.0.28) (2021-06-21)


### Bug Fixes

* **GPG:** ioctl error while deploying ([1fd14f2](https://github.com/IBM/scc-java-sdk/commit/1fd14f24dba9d5a629c234c1c862f2ff6e918b62))

## [0.0.27](https://github.com/IBM/scc-java-sdk/compare/0.0.26...0.0.27) (2021-06-18)


### Bug Fixes

* **GithubAction:** GHAction using gpg2 by default ([0632ca1](https://github.com/IBM/scc-java-sdk/commit/0632ca1b8cd387455f54069838628acb1a0353d4))

## [0.0.26](https://github.com/IBM/scc-java-sdk/compare/0.0.25...0.0.26) (2021-06-18)


### Bug Fixes

* **TTY:** export GPG_TTY before gpg signing ([5711627](https://github.com/IBM/scc-java-sdk/commit/57116270189093a041587c0b79d3aca32c6b528f))

## [0.0.25](https://github.com/IBM/scc-java-sdk/compare/0.0.24...0.0.25) (2021-06-18)


### Bug Fixes

* **GPG:** signing files before publishing ([df40f3e](https://github.com/IBM/scc-java-sdk/commit/df40f3ec8e41b87b6331fb9e7dd4b7c7c4b6a92d))

## [0.0.24](https://github.com/IBM/scc-java-sdk/compare/0.0.23...0.0.24) (2021-06-18)


### Bug Fixes

* **GithubAction:** publish and document for any tag ([3914cb8](https://github.com/IBM/scc-java-sdk/commit/3914cb81eb042040f88c44e6aad6f57802c16fb6))

## [0.0.23](https://github.com/IBM/scc-java-sdk/compare/0.0.22...0.0.23) (2021-06-18)


### Bug Fixes

* **GithubAction:** workflow altered ([0cee3c0](https://github.com/IBM/scc-java-sdk/commit/0cee3c018f2179b1ef9fd1d371306d439ebfda5a))

## [0.0.22](https://github.com/IBM/scc-java-sdk/compare/0.0.21...0.0.22) (2021-06-17)


### Bug Fixes

* **GitHubActions:** migrated from TravisCI ([9ce7a06](https://github.com/IBM/scc-java-sdk/commit/9ce7a06345ca4836e745d152ff7ab35935a679cb))

## [0.0.21](https://github.com/IBM/scc-java-sdk/compare/0.0.20...0.0.21) (2021-06-14)


### Bug Fixes

* **ITs:** config gov ITs fixed ([f53590b](https://github.com/IBM/scc-java-sdk/commit/f53590b6e74765a14831330cb981b1a7db21e751))

## [0.0.20](https://github.com/IBM/scc-java-sdk/compare/0.0.19...0.0.20) (2021-06-11)


### Bug Fixes

* **apidef:** Addressed api definition review comments ([86b54af](https://github.com/IBM/scc-java-sdk/commit/86b54afe595ca44940c91a374479b5b3cec31900))

## [0.0.19](https://github.com/IBM/scc-java-sdk/compare/0.0.18...0.0.19) (2021-06-07)


### Bug Fixes

* **SDK:** IBM Cloud SCC Java SDK ([135feb4](https://github.com/IBM/scc-java-sdk/commit/135feb4e41db81650a68479378131c9a21a29c2e))

## [0.0.18](https://github.com/IBM/scc-java-sdk/compare/0.0.17...0.0.18) (2021-06-02)


### Bug Fixes

* **SDK:** IBM Cloud SCC Java SDK ([0c4514a](https://github.com/IBM/scc-java-sdk/commit/0c4514ac3f0400f230ff4684f91f53bd35375115))

## [0.0.17](https://github.com/IBM/scc-java-sdk/compare/0.0.16...0.0.17) (2021-06-02)


### Bug Fixes

* **SemanticRelease:** skip CI ops on SR commits ([e1406f2](https://github.com/IBM/scc-java-sdk/commit/e1406f2b2bb6d2f15d726072a7f1eeb042d610d4))
* **Travis:** after_success has to be used with explicit failure mechanism ([6538976](https://github.com/IBM/scc-java-sdk/commit/65389763ed7e2a4b0de75fe957b90bce26c9ecba))

## [0.0.16](https://github.com/IBM/scc-java-sdk/compare/0.0.15...0.0.16) (2021-06-02)


### Bug Fixes

* **SDK:** IBM Cloud SCC Java SDK ([8580778](https://github.com/IBM/scc-java-sdk/commit/8580778242af80c962f88ea3f0de267eddb0fe64))

## [0.0.15](https://github.com/IBM/scc-java-sdk/compare/0.0.14...0.0.15) (2021-06-02)


### Bug Fixes

* **SDK:** IBM Cloud SCC Java SDK ([29d5402](https://github.com/IBM/scc-java-sdk/commit/29d5402c46bd52153c817e08f0b4eccbd14df22f))

## [0.0.14](https://github.com/IBM/scc-java-sdk/compare/0.0.13...0.0.14) (2021-06-02)


### Bug Fixes

* **Javadoc:** Javadoc create and publish within  stage ([452160c](https://github.com/IBM/scc-java-sdk/commit/452160c19df8c6b6c836904a562bd4c9a155e4c4))

## [0.0.13](https://github.com/IBM/scc-java-sdk/compare/0.0.12...0.0.13) (2021-06-01)


### Bug Fixes

* **IT:** commit to retrigger build process ([3b09c5e](https://github.com/IBM/scc-java-sdk/commit/3b09c5ebb76f3f06257852dedc054b71928ab373))
* **Travis:** tag IS present ([e912457](https://github.com/IBM/scc-java-sdk/commit/e9124575745fc454313faf553615415b065804f3))

## [0.0.12](https://github.com/IBM/scc-java-sdk/compare/0.0.11...0.0.12) (2021-06-01)


### Bug Fixes

* **IBM Cloud SCC Java SDK Travis:** Release stage should not run for semantic-release-bot commits ([a5fdaa2](https://github.com/IBM/scc-java-sdk/commit/a5fdaa202730686fe61106b26cb3fd23d878b627))

## [0.0.11](https://github.com/IBM/scc-java-sdk/compare/0.0.10...0.0.11) (2021-06-01)


### Bug Fixes

* **Travis:** IBM Cloud SCC Java SDK Travis configuration fixed ([ea3b563](https://github.com/IBM/scc-java-sdk/commit/ea3b5631d7920b7243ca275f300ac6d24551b8b4))

## [0.0.10](https://github.com/IBM/scc-java-sdk/compare/0.0.9...0.0.10) (2021-06-01)


### Bug Fixes

* **SDK:** IBM Cloud SCC Java SDK ([a79cf02](https://github.com/IBM/scc-java-sdk/commit/a79cf02b7a8b08ee96f61015af4efeb2cc004e92))

## [0.0.9](https://github.com/IBM/scc-java-sdk/compare/0.0.8...0.0.9) (2021-06-01)


### Bug Fixes

* **SDK:** IBM Cloud SCC Java SDK ([0bfe060](https://github.com/IBM/scc-java-sdk/commit/0bfe060d3eb4414add4a592ad9fb28be783aa165))

## [0.0.8](https://github.com/IBM/scc-java-sdk/compare/0.0.7...0.0.8) (2021-05-31)


### Bug Fixes

* **SDK:** IBM Cloud SCC Java SDK ([e553e4f](https://github.com/IBM/scc-java-sdk/commit/e553e4f091e0ceb741b1dfe6f2d358c2ca0db655))

## [0.0.7](https://github.com/IBM/scc-java-sdk/compare/0.0.6...0.0.7) (2021-05-31)


### Bug Fixes

* **Travis:** travis stages sequence fixed ([7186658](https://github.com/IBM/scc-java-sdk/commit/7186658bad398aff88c15577b1152d612043795e))

## [0.0.6](https://github.com/IBM/scc-java-sdk/compare/0.0.5...0.0.6) (2021-05-31)


### Bug Fixes

* **TRI:** region based service URL feature added ([75d6eeb](https://github.com/IBM/scc-java-sdk/commit/75d6eeb245ec212e5e7769f9568b5a5672427572))
* **TRI:** region based service URL feature added ([80df08d](https://github.com/IBM/scc-java-sdk/commit/80df08d6dd9acaaf90b616d55a083dbff61351b9))

## [0.0.5](https://github.com/IBM/scc-java-sdk/compare/0.0.4...0.0.5) (2021-04-29)


### Bug Fixes

* **IBM Cloud SCC:** javadoc publish issue ([9a26193](https://github.com/IBM/scc-java-sdk/commit/9a26193775d722d1a9ffcc0cd82b1fa100b0fa6d))
* **IBM Cloud SCC:** javadoc publish issue ([c8e97aa](https://github.com/IBM/scc-java-sdk/commit/c8e97aa7ba64dd7fdff1769a1d8917b1b7f6f28d))

## [0.0.4](https://github.com/IBM/scc-java-sdk/compare/0.0.3...0.0.4) (2021-04-29)


### Bug Fixes

* **IBM Cloud SCC:** first release to MVN central ([4faefb1](https://github.com/IBM/scc-java-sdk/commit/4faefb156810deaa4707db425be94a1e926fb058))

## [0.0.3](https://github.com/IBM/scc-java-sdk/compare/0.0.2...0.0.3) (2021-04-29)


### Bug Fixes

* **IBM Cloud SCC:** first release to MVN central ([60aa40b](https://github.com/IBM/scc-java-sdk/commit/60aa40b1357a8827acacbd28fc08edc5ee410fc1))
* **IBM Cloud SCC:** first release to MVN central ([1f2b8d1](https://github.com/IBM/scc-java-sdk/commit/1f2b8d1bae1ff5a60a2b93a43d91c2745d42853e))

## [0.0.2](https://github.com/IBM/scc-java-sdk/compare/v0.0.1...0.0.2) (2021-04-28)


### Bug Fixes

* **IBM Cloud SCC:** first release ([b977d4b](https://github.com/IBM/scc-java-sdk/commit/b977d4b39a1ec22381ee69da366cae277dbd5a10))
* **IBM Cloud SCC:** first release ([328e71d](https://github.com/IBM/scc-java-sdk/commit/328e71d7ca00b47952ded8437bade1b67490f1e4))
* **IBM Cloud SCC:** first release ([c70ee0b](https://github.com/IBM/scc-java-sdk/commit/c70ee0bcea30e626b15aef3ec813f7d29a8f526c))
* **IBM Cloud SCC:** first release ([90f640e](https://github.com/IBM/scc-java-sdk/commit/90f640e50acb9c6f2e286c05e8643ba6192a6de9))

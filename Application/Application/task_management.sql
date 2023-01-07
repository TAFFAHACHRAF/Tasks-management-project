-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 07 jan. 2023 à 14:06
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `task_management`
--

-- --------------------------------------------------------

--
-- Structure de la table `affecter_intervenant`
--

CREATE TABLE `affecter_intervenant` (
  `ID` int(11) NOT NULL,
  `TASK_ID` int(11) NOT NULL,
  `INTERVENANT_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `affecter_intervenant`
--

INSERT INTO `affecter_intervenant` (`ID`, `TASK_ID`, `INTERVENANT_ID`) VALUES
(2, 1, 15);

-- --------------------------------------------------------

--
-- Structure de la table `affecter_materiel`
--

CREATE TABLE `affecter_materiel` (
  `ID` int(11) NOT NULL,
  `TASK_ID` int(11) NOT NULL,
  `MATERIEL_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `affecter_materiel`
--

INSERT INTO `affecter_materiel` (`ID`, `TASK_ID`, `MATERIEL_ID`) VALUES
(1, 1, 48),
(2, 1, 48),
(4, 1, 5),
(5, 1, 5),
(6, 1, 5);

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `ID` int(11) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `RESPONSABLE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`ID`, `TYPE`, `NOM`, `RESPONSABLE_ID`) VALUES
(5, 'rofj', 'rifj', 27),
(8, 'rofj', 'rifj', 16),
(10, 'rofj', 'rifj', 16),
(19, 'rofj', 'rifj', 16),
(48, 'rofj', 'rifj', 16);

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `ID` int(11) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `DATE` date NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL,
  `TASK_ID` int(11) NOT NULL,
  `INTERVENANT_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order_de_travail`
--

CREATE TABLE `order_de_travail` (
  `ID` int(11) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(50) NOT NULL,
  `TASK_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `ID` int(11) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `DATE_DEBUT` date NOT NULL,
  `RESPONSABLE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`ID`, `TITLE`, `DATE_DEBUT`, `RESPONSABLE_ID`) VALUES
(2, 'azdoipaejf', '2023-01-10', 15);

-- --------------------------------------------------------

--
-- Structure de la table `task`
--

CREATE TABLE `task` (
  `ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL,
  `DATE_DEBUT` date NOT NULL,
  `DATE_FIN` date NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `PROJET_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `task`
--

INSERT INTO `task` (`ID`, `DESCRIPTION`, `DATE_DEBUT`, `DATE_FIN`, `TITLE`, `PROJET_ID`) VALUES
(1, 'azdkkzd', '2023-01-11', '2023-01-28', 'azdok', 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) NOT NULL,
  `CIN` varchar(50) NOT NULL,
  `TEL` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `isResponsable` tinyint(1) NOT NULL,
  `isIntervenant` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`ID`, `NOM`, `PRENOM`, `CIN`, `TEL`, `EMAIL`, `PASSWORD`, `isResponsable`, `isIntervenant`) VALUES
(15, 'oij', 'ij', 'io', 'ijo', 'ioj', 'ijo', 0, 1),
(16, 'Achraf', 'TAFFAH', 'BJ473674', '0684134782', 'taffahachraf184@gmail.com', '1234', 1, 0),
(17, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(18, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(19, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(20, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(21, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(22, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(23, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(24, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(25, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(26, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(27, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(28, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(29, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(30, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(31, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(32, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(33, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(34, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(35, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(36, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(37, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(38, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(39, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(40, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(41, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(42, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(43, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(44, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(45, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(46, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(47, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(48, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(49, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(50, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(51, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(52, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(53, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(54, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(55, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(56, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(57, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(58, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(59, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(60, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(61, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(62, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(63, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(64, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1),
(65, 'iueizfh', 'oijef', 'oifje', 'efoij', 'oifehj', 'fiuh', 0, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `affecter_intervenant`
--
ALTER TABLE `affecter_intervenant`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `INTERVENANT_ID` (`INTERVENANT_ID`),
  ADD KEY `TASK_ID` (`TASK_ID`);

--
-- Index pour la table `affecter_materiel`
--
ALTER TABLE `affecter_materiel`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `MATERIEL_ID` (`MATERIEL_ID`),
  ADD KEY `TASK_ID` (`TASK_ID`);

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `materiel_FK_1` (`RESPONSABLE_ID`);

--
-- Index pour la table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TASK_ID_FK_1` (`TASK_ID`),
  ADD KEY `INTERVENANT_ID` (`INTERVENANT_ID`);

--
-- Index pour la table `order_de_travail`
--
ALTER TABLE `order_de_travail`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `order_de_travail_FK_1` (`TASK_ID`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `projet_FK_1` (`RESPONSABLE_ID`);

--
-- Index pour la table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `task_FK_1` (`PROJET_ID`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `affecter_intervenant`
--
ALTER TABLE `affecter_intervenant`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `affecter_materiel`
--
ALTER TABLE `affecter_materiel`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `materiel`
--
ALTER TABLE `materiel`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT pour la table `notification`
--
ALTER TABLE `notification`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `order_de_travail`
--
ALTER TABLE `order_de_travail`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `task`
--
ALTER TABLE `task`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `affecter_intervenant`
--
ALTER TABLE `affecter_intervenant`
  ADD CONSTRAINT `affecter_intervenant_ibfk_1` FOREIGN KEY (`INTERVENANT_ID`) REFERENCES `user` (`ID`),
  ADD CONSTRAINT `affecter_intervenant_ibfk_2` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`ID`);

--
-- Contraintes pour la table `affecter_materiel`
--
ALTER TABLE `affecter_materiel`
  ADD CONSTRAINT `affecter_materiel_ibfk_1` FOREIGN KEY (`MATERIEL_ID`) REFERENCES `materiel` (`ID`),
  ADD CONSTRAINT `affecter_materiel_ibfk_2` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`ID`);

--
-- Contraintes pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD CONSTRAINT `materiel_FK_1` FOREIGN KEY (`RESPONSABLE_ID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `TASK_ID_FK_1` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`ID`),
  ADD CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`INTERVENANT_ID`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `order_de_travail`
--
ALTER TABLE `order_de_travail`
  ADD CONSTRAINT `order_de_travail_FK_1` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`ID`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_1` FOREIGN KEY (`RESPONSABLE_ID`) REFERENCES `user` (`ID`);

--
-- Contraintes pour la table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_FK_1` FOREIGN KEY (`PROJET_ID`) REFERENCES `projet` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

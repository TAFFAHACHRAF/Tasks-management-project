-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 06 jan. 2023 à 21:25
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
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `ID` int(11) NOT NULL,
  `TYPE` varchar(50) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `RESPONSABLE_ID` int(11) NOT NULL,
  `TASK_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `PROJET_ID` int(11) NOT NULL,
  `INTERVENANT_ID` int(11) NOT NULL,
  `MATERIEL_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(16, 'Achraf', 'TAFFAH', 'BJ473674', '0684134782', 'taffahachraf184@gmail.com', '1234', 1, 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `materiel_FK_1` (`RESPONSABLE_ID`),
  ADD KEY `TASK_ID` (`TASK_ID`);

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
  ADD KEY `task_FK_1` (`PROJET_ID`),
  ADD KEY `MATERIEL_ID` (`MATERIEL_ID`),
  ADD KEY `INTERVENANT_ID` (`INTERVENANT_ID`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `materiel`
--
ALTER TABLE `materiel`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `task`
--
ALTER TABLE `task`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD CONSTRAINT `materiel_FK_1` FOREIGN KEY (`RESPONSABLE_ID`) REFERENCES `user` (`ID`),
  ADD CONSTRAINT `materiel_ibfk_1` FOREIGN KEY (`TASK_ID`) REFERENCES `task` (`ID`);

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
  ADD CONSTRAINT `task_FK_1` FOREIGN KEY (`PROJET_ID`) REFERENCES `projet` (`ID`),
  ADD CONSTRAINT `task_ibfk_1` FOREIGN KEY (`MATERIEL_ID`) REFERENCES `materiel` (`ID`),
  ADD CONSTRAINT `task_ibfk_2` FOREIGN KEY (`INTERVENANT_ID`) REFERENCES `user` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.service;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.exceptions.ElementAlreadyExistsException;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.exceptions.ElementNotFoundException;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.model.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    ModelMapper modelMapper;
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        if (findByName(playerDTO))
            throw new ElementAlreadyExistsException(Player.class, playerDTO.getName());
        else {
            Player player = playerRepository.save(convertDtoToEntity(playerDTO));
            return convertEntityToDto(player);
        }
    }

    @Override
    public Object updatePlayer(Integer id, PlayerDTO playerDTO) {

        Optional<Player> playerOptional = playerRepository.findById(playerDTO.getId());
        if (playerOptional.isEmpty())
            throw new ElementNotFoundException(Player.class, id);
        else {
            if (findByName(playerDTO))
                throw new ElementAlreadyExistsException(Player.class, playerDTO.getName());
            else {
                Player player = playerOptional.get();
                player.setName(playerDTO.getName());
                return playerRepository.save(player);
            }

        }
    }

    @Override
    public Player getPlayerById(Integer id) {

            Optional<Player> optionalPlayer = playerRepository.findById(id);
            if (optionalPlayer.isEmpty()) throw new ElementNotFoundException(Player.class, id);
            Player player = optionalPlayer.get();
            return player;

    }

    private boolean findByName(PlayerDTO playerDTO) {
        Optional<Player> playerOptional = playerRepository.findPlayerByName(playerDTO.getName());
        if (playerOptional.isPresent())
            return true;
        else
            return false;
    }

    private Player convertDtoToEntity(PlayerDTO playerDTO) {
        Player player = modelMapper.map(playerDTO, Player.class);
        if (player.getName() == null || player.getName() == "") player.setName("ANONIMO");
        if (player.getDate() == null) player.setDate(new Date());
        return player;
    }

    private PlayerDTO convertEntityToDto(Player player) {
        return new PlayerDTO(player.getId(), player.getName());
    }

}

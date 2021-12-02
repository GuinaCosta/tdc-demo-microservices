using Microsoft.AspNetCore.Mvc;
using APICotacoes.Data;

namespace APICotacoes.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class CotacoesController : ControllerBase
    {
        [HttpGet("{moeda}")]
        public ContentResult Get(
            [FromServices]RedisConnection redisConnection,
            string moeda)
        {
            return Content(redisConnection.GetValueFromKey(
                $"Cotacao-{moeda.ToUpper()}") ?? "{}", "application/json");
        }

        [HttpPost("{moeda}")]
        public ContentResult Save(
            [FromServices]RedisConnection redisConnection,
            [FromBody] string value,
            string moeda
        )
        {
            redisConnection.SaveValue($"Cotacao-{moeda.ToUpper()}", value);
            return Content("ok", "application/json");
        }
    }
}